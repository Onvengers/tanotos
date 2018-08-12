import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;
import bwta.BWTA;
import bwta.BaseLocation;
import bwta.Chokepoint;

/// 상황을 판단하여, 정찰, 빌드, 공격, 방어 등을 수행하도록 총괄 지휘를 하는 class <br>
/// InformationManager 에 있는 정보들로부터 상황을 판단하고, <br>
/// BuildManager 의 buildQueue에 빌드 (건물 건설 / 유닛 훈련 / 테크 리서치 / 업그레이드) 명령을 입력합니다.<br>
/// 정찰, 빌드, 공격, 방어 등을 수행하는 코드가 들어가는 class
public class StrategyManager {

	private static StrategyManager instance = new StrategyManager();
	private CommandUtil commandUtil = new CommandUtil();

	private boolean isFullScaleAttackStarted;
	private boolean isInitialBuildOrderFinished;
	private boolean isBuildedAdun;

	private Map<StrategyType, List<StrategyRule>> strategyRules = new HashMap<StrategyType, List<StrategyRule>>();

	// 경기 결과 파일 Save / Load 및 로그파일 Save 예제 추가를 위한 변수 및 메소드 선언

	/// 한 게임에 대한 기록을 저장하는 자료구조
	private class GameRecord {
		String mapName;
		String enemyName;
		String enemyRace;
		String enemyRealRace;
		String myName;
		String myRace;
		int gameFrameCount = 0;
		int myWinCount = 0;
		int myLoseCount = 0;
	}

	/// 과거 전체 게임들의 기록을 저장하는 자료구조
	ArrayList<GameRecord> gameRecordList = new ArrayList<GameRecord>();

	/// static singleton 객체를 리턴합니다
	public static StrategyManager Instance() {
		return instance;
	}

	public StrategyManager() {
		isFullScaleAttackStarted = false;
		isInitialBuildOrderFinished = false;
	}

	/// 경기가 시작될 때 일회적으로 전략 초기 세팅 관련 로직을 실행합니다
	public void onStart() {
		loadGameRecordList();
		StatusIndicator.Instance();
		// Strategy rule을 로딩합니다.
		setInitializeStrategyRules();
		// setInitialBuildOrder();
	}

	private void setInitializeStrategyRules() {
		// 일꾼
		addStrategyRules(new StrategyRuleVsZergTrainingWorker(StrategyType.Worker));
		// 서플라이
		addStrategyRules(new StrategyRuleVsZergBuildSupply(StrategyType.Supply));
		// 건물
		addStrategyRules(new StrategyRuleVsZergBuildGateway(StrategyType.CombatBuild));
		addStrategyRules(new StrategyRuleVsZergBuildGas(StrategyType.CombatBuild));
		addStrategyRules(new StrategyRuleVsZergBuildForge(StrategyType.CombatBuild));
		addStrategyRules(new StrategyRuleVsZergBuildCore(StrategyType.CombatBuild));
		addStrategyRules(new StrategyRuleVsZergBuildAdun(StrategyType.CombatBuild));
		addStrategyRules(new StrategyRuleVsZergBuildSecondCenter(StrategyType.CombatBuild));
		addStrategyRules(new StrategyRuleVsZergBuildMoreUpgrade(StrategyType.CombatBuild));
		addStrategyRules(new StrategyRuleVsZergBuildObserver(StrategyType.CombatBuild));
		addStrategyRules(new StrategyRuleVsZergBuildPhoto(StrategyType.CombatBuild));
		//addStrategyRules(new StrategyRuleVsZergBuildTemplarArchive(StrategyType.CombatBuild));
		// 업그레이드
		addStrategyRules(new StrategyRuleVsZergUpgradeOnForge(StrategyType.Upgrade));
		addStrategyRules(new StrategyRuleVsZergUpgradeZealotLeg(StrategyType.Upgrade));
		addStrategyRules(new StrategyRuleVsZergUpgradeDragoonRangeUp(StrategyType.Upgrade));
		// 유닛
		addStrategyRules(new StrategyRuleVsZergTrainingZealot(StrategyType.CombatUnit));
		addStrategyRules(new StrategyRuleVsZergTrainingDragoon(StrategyType.CombatUnit));
		//addStrategyRules(new StrategyRuleVsZergTrainingHighTempler(StrategyType.CombatUnit));
		//addStrategyRules(new StrategyRuleVsZergTrainingArchon(StrategyType.CombatUnit));
		
//		if (MyBotModule.Broodwar.enemy().getRace() == Race.Zerg) {
//		} else if (MyBotModule.Broodwar.enemy().getRace() == Race.Terran) {
//		} else if (MyBotModule.Broodwar.enemy().getRace() == Race.Protoss) {
//		} else {
//		}
	}

	private void addStrategyRules(StrategyRule rule) {
		if (!strategyRules.containsKey(rule.getStrategyType())) {
			strategyRules.put(rule.getStrategyType(), new LinkedList<StrategyRule>());
		}

		strategyRules.get(rule.getStrategyType()).add(rule);
	}

	public void setInitialBuildOrder() {
		BuildStrategy initBuildStrategy = BuildStrategyFactory.getInstance()
				.createBuildStrategy(MyBotModule.Broodwar.enemy().getRace());
		BuildOrderAdjuster.getInstance().initialBuildOrders(initBuildStrategy);
	}

	/// 경기가 종료될 때 일회적으로 전략 결과 정리 관련 로직을 실행합니다
	public void onEnd(boolean isWinner) {
		// 과거 게임 기록 + 이번 게임 기록을 저장합니다
		saveGameRecordList(isWinner);
	}

	/// 경기 진행 중 매 프레임마다 경기 전략 관련 로직을 실행합니다
	public void update() {

		executeWorkerTraining();

		executeSupplyManagement();

		executeBuildingManagement();

		executeCombatUnitTraining();

		executeUpgradeManagement();

		// saveGameLog();
	}

	// 일꾼 생산
	public void executeWorkerTraining() {
		executeBuildStrategy(StrategyType.Worker);
	}

	// 파일럿 관리
	public void executeSupplyManagement() {
		executeBuildStrategy(StrategyType.Supply);
	}

	// 건물 생산
	public void executeBuildingManagement() {
		executeBuildStrategy(StrategyType.CombatBuild);
	}

	// 공격유닛 생산
	public void executeCombatUnitTraining() {
		executeBuildStrategy(StrategyType.CombatUnit);
	}

	// 업그레이드 관리
	public void executeUpgradeManagement() {
		executeBuildStrategy(StrategyType.Upgrade);
	}

	private void executeBuildStrategy(StrategyType strategyType) {
		BuildStrategy bs;

		for (StrategyRule rule : this.strategyRules.get(strategyType)) {
			bs = BuildStrategyFactory.getInstance().createBuildStrategy(rule.judgeStrategy());

			if (bs != null) {
				bs.setBuildOrder();
				BuildOrderAdjuster.getInstance().rearrangeBuildOrders(bs);
			}
		}

		return;
	}

	/// 과거 전체 게임 기록을 로딩합니다
	void loadGameRecordList() {

		// 과거의 게임에서 bwapi-data\write 폴더에 기록했던 파일은 대회 서버가 bwapi-data\read 폴더로 옮겨놓습니다
		// 따라서, 파일 로딩은 bwapi-data\read 폴더로부터 하시면 됩니다

		// TODO : 파일명은 각자 봇 명에 맞게 수정하시기 바랍니다
		String gameRecordFileName = "c:\\starcraft\\bwapi-data\\read\\NoNameBot_GameRecord.dat";

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(gameRecordFileName));

			System.out.println("loadGameRecord from file: " + gameRecordFileName);

			String currentLine;
			StringTokenizer st;
			GameRecord tempGameRecord;
			while ((currentLine = br.readLine()) != null) {

				st = new StringTokenizer(currentLine, " ");
				tempGameRecord = new GameRecord();
				if (st.hasMoreTokens()) {
					tempGameRecord.mapName = st.nextToken();
				}
				if (st.hasMoreTokens()) {
					tempGameRecord.myName = st.nextToken();
				}
				if (st.hasMoreTokens()) {
					tempGameRecord.myRace = st.nextToken();
				}
				if (st.hasMoreTokens()) {
					tempGameRecord.myWinCount = Integer.parseInt(st.nextToken());
				}
				if (st.hasMoreTokens()) {
					tempGameRecord.myLoseCount = Integer.parseInt(st.nextToken());
				}
				if (st.hasMoreTokens()) {
					tempGameRecord.enemyName = st.nextToken();
				}
				if (st.hasMoreTokens()) {
					tempGameRecord.enemyRace = st.nextToken();
				}
				if (st.hasMoreTokens()) {
					tempGameRecord.enemyRealRace = st.nextToken();
				}
				if (st.hasMoreTokens()) {
					tempGameRecord.gameFrameCount = Integer.parseInt(st.nextToken());
				}

				gameRecordList.add(tempGameRecord);
			}
		} catch (FileNotFoundException e) {
			System.out.println("loadGameRecord failed. Could not open file :" + gameRecordFileName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/// 과거 전체 게임 기록 + 이번 게임 기록을 저장합니다
	void saveGameRecordList(boolean isWinner) {

		// 이번 게임의 파일 저장은 bwapi-data\write 폴더에 하시면 됩니다.
		// bwapi-data\write 폴더에 저장된 파일은 대회 서버가 다음 경기 때 bwapi-data\read 폴더로 옮겨놓습니다

		// TODO : 파일명은 각자 봇 명에 맞게 수정하시기 바랍니다
		String gameRecordFileName = "c:\\starcraft\\bwapi-data\\write\\NoNameBot_GameRecord.dat";

		System.out.println("saveGameRecord to file: " + gameRecordFileName);

		String mapName = MyBotModule.Broodwar.mapFileName();
		mapName = mapName.replace(' ', '_');
		String enemyName = MyBotModule.Broodwar.enemy().getName();
		enemyName = enemyName.replace(' ', '_');
		String myName = MyBotModule.Broodwar.self().getName();
		myName = myName.replace(' ', '_');

		/// 이번 게임에 대한 기록
		GameRecord thisGameRecord = new GameRecord();
		thisGameRecord.mapName = mapName;
		thisGameRecord.myName = myName;
		thisGameRecord.myRace = MyBotModule.Broodwar.self().getRace().toString();
		thisGameRecord.enemyName = enemyName;
		thisGameRecord.enemyRace = MyBotModule.Broodwar.enemy().getRace().toString();
		thisGameRecord.enemyRealRace = InformationManager.Instance().enemyRace.toString();
		thisGameRecord.gameFrameCount = MyBotModule.Broodwar.getFrameCount();
		if (isWinner) {
			thisGameRecord.myWinCount = 1;
			thisGameRecord.myLoseCount = 0;
		} else {
			thisGameRecord.myWinCount = 0;
			thisGameRecord.myLoseCount = 1;
		}
		// 이번 게임 기록을 전체 게임 기록에 추가
		gameRecordList.add(thisGameRecord);

		// 전체 게임 기록 write
		StringBuilder ss = new StringBuilder();
		for (GameRecord gameRecord : gameRecordList) {
			ss.append(gameRecord.mapName + " ");
			ss.append(gameRecord.myName + " ");
			ss.append(gameRecord.myRace + " ");
			ss.append(gameRecord.myWinCount + " ");
			ss.append(gameRecord.myLoseCount + " ");
			ss.append(gameRecord.enemyName + " ");
			ss.append(gameRecord.enemyRace + " ");
			ss.append(gameRecord.enemyRealRace + " ");
			ss.append(gameRecord.gameFrameCount + "\n");
		}

		Common.overwriteToFile(gameRecordFileName, ss.toString());
	}

	/// 이번 게임 중간에 상시적으로 로그를 저장합니다
	void saveGameLog() {

		// 100 프레임 (5초) 마다 1번씩 로그를 기록합니다
		// 참가팀 당 용량 제한이 있고, 타임아웃도 있기 때문에 자주 하지 않는 것이 좋습니다
		// 로그는 봇 개발 시 디버깅 용도로 사용하시는 것이 좋습니다
		if (MyBotModule.Broodwar.getFrameCount() % 100 != 0) {
			return;
		}

		// TODO : 파일명은 각자 봇 명에 맞게 수정하시기 바랍니다
		String gameLogFileName = "c:\\starcraft\\bwapi-data\\write\\NoNameBot_LastGameLog.dat";

		String mapName = MyBotModule.Broodwar.mapFileName();
		mapName = mapName.replace(' ', '_');
		String enemyName = MyBotModule.Broodwar.enemy().getName();
		enemyName = enemyName.replace(' ', '_');
		String myName = MyBotModule.Broodwar.self().getName();
		myName = myName.replace(' ', '_');

		StringBuilder ss = new StringBuilder();
		ss.append(mapName + " ");
		ss.append(myName + " ");
		ss.append(MyBotModule.Broodwar.self().getRace().toString() + " ");
		ss.append(enemyName + " ");
		ss.append(InformationManager.Instance().enemyRace.toString() + " ");
		ss.append(MyBotModule.Broodwar.getFrameCount() + " ");
		ss.append(MyBotModule.Broodwar.self().supplyUsed() + " ");
		ss.append(MyBotModule.Broodwar.self().supplyTotal() + "\n");

		Common.appendTextToFile(gameLogFileName, ss.toString());
	}

	// BasicBot 1.1 Patch End //////////////////////////////////////////////////

}