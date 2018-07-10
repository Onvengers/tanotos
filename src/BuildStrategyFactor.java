import java.util.HashMap;
import java.util.Map;

public abstract class BuildStrategyFactor {

	protected Strategy myStrategy;

	private static final Map<Class<? extends BuildStrategyFactor>, BuildStrategyFactor> instances = new HashMap<Class<? extends BuildStrategyFactor>, BuildStrategyFactor>();

	public static BuildStrategyFactor getInstance(Class<? extends BuildStrategyFactor> cls)
			throws InstantiationException, IllegalAccessException {
		if (instances.get(cls) == null) {
			synchronized (instances) {
				if (instances.get(cls) == null) {
					instances.put(cls, cls.newInstance());
				}
			}
		}
		return instances.get(cls);
	}
	
	public abstract void setBuildStrategyFactor(String key, Object value);
	
	public abstract Object getBuildStrategyFactor(String key);

}
