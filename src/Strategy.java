
public enum Strategy {

	SAMPLE,
	//========= 적 종족에 대한 기본 Build Order
	VS_TERRAN,
	VS_ZERG,
	VS_PROTOSS,
	//========= 대비 Build Order
	RESPOND_FAST_ZERGLING,
	RESPOND_PHOTON_RUSH,
	RESPOND_BUNKER_RUSH,
	//========= 테크트리 변형용 Build Order
	CHG_CARRIER,
	CHG_LIVER,
	//=========================== 건물
	BUILD_SUPPLY,
	BUILD_GATEWAY,
	BUILD_GAS,
	BUILD_FORGE,
	BUILD_CORE,
	BUILD_ADUN,
	BUILD_TEMPLAR_ARCHIVE,
	//=========================== 유닛
	ADD_PROBE,
	ADD_ZEALOT,
	ADD_HIGH_TEMPLER,
	ADD_ARCHON,
	//=========================== 업그레이드
	UPGRADE_WEAPON,
	UPGRADE_ARMOR,
	UPGRADE_PLASMA,
	UPGRADE_ZEALOT_LEG
}
