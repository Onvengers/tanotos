import bwapi.UnitType;

public class BuildStrategyVsTerran extends BuildStrategy {

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		
		this.queueBuild(true, UnitType.Protoss_Probe);		// 5 probe
		this.queueBuild(true, UnitType.Protoss_Probe);		// 6 probe
		this.queueBuild(true, UnitType.Protoss_Probe);		// 7 probe
		this.queueBuild(true, UnitType.Protoss_Probe);		// 8 probe
		this.queueBuild(true, UnitType.Protoss_Pylon);		// 파일런
		this.queueBuild(true, UnitType.Protoss_Probe);		// 9 probe
		this.queueBuild(true, UnitType.Protoss_Gateway);	// 게이트웨이
		this.queueBuild(true, UnitType.Protoss_Probe);		// 10 probe
		this.queueBuild(false, UnitType.Protoss_Cybernetics_Core);	// 사이버네틱스 코어
		this.queueBuild(true, UnitType.Protoss_Pylon);		// 파일런
		
		/*
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Assimilator,
				BuildOrderItem.SeedPositionStrategy.MainBaseLocation);

		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Forge,
				BuildOrderItem.SeedPositionStrategy.MainBaseLocation);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Photon_Cannon,
				BuildOrderItem.SeedPositionStrategy.MainBaseLocation);

		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Gateway,
				BuildOrderItem.SeedPositionStrategy.MainBaseLocation);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Zealot);

		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Cybernetics_Core,
				BuildOrderItem.SeedPositionStrategy.MainBaseLocation);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Dragoon);
		// 드라군 사정거리 업그레이드
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Singularity_Charge);

		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Citadel_of_Adun);
		// 질럿 속도 업그레이드
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Leg_Enhancements);

		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Shield_Battery);

		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Templar_Archives);
		// 하이템플러
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_High_Templar);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_High_Templar);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(TechType.Psionic_Storm);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(TechType.Hallucination);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Khaydarin_Amulet);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Archon);

		// 다크아칸
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Dark_Templar);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Dark_Templar);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(TechType.Maelstrom);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(TechType.Mind_Control);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Argus_Talisman);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Dark_Archon);

		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Robotics_Facility);

		// 셔틀
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Shuttle);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Robotics_Support_Bay);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Gravitic_Drive);

		// 리버
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Reaver);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Scarab_Damage);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Reaver_Capacity);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Scarab);

		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Observatory);
		// 옵저버
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Observer);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Gravitic_Boosters);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Sensor_Array);

		// 공중유닛
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Stargate);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Fleet_Beacon);

		// 스카우트
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Scout);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Apial_Sensors);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Gravitic_Thrusters);

		// 커세어
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Corsair);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(TechType.Disruption_Web);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Argus_Jewel);

		// 캐리어
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Carrier);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Carrier_Capacity);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Interceptor);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Interceptor);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Interceptor);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Interceptor);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Interceptor);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Interceptor);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Interceptor);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Interceptor);

		// 아비터
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Arbiter_Tribunal);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Protoss_Arbiter);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(TechType.Recall);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(TechType.Stasis_Field);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Khaydarin_Core);

		// 포지 - 지상 유닛 업그레이드
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Protoss_Ground_Weapons);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Protoss_Plasma_Shields);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Protoss_Ground_Armor);

		// 사이버네틱스코어 - 공중 유닛 업그레이드
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Protoss_Air_Weapons);
		BuildManager.Instance().buildQueue.queueAsLowestPriority(UpgradeType.Protoss_Air_Armor);

		*/
				
	}

}
