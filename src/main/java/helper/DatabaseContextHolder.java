package helper;

public class DatabaseContextHolder {

	// 定义数据源 - 每个数据源都要在这里注册
    public static final String DATA_SOURCE_1 = "dataSourceA";// 对应在beans.xml里面注册的数据源的key
    public static final String DATA_SOURCE_2 = "dataSourceB";

    // ThreadLocal：用于解决线程安全问题。每个线程都会拥有一个独立的变量副本。线程内部可以独立的改变，而不影响其他线程
    public static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDataSourceType(String type) {
        contextHolder.set(type);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }
    
    public static void clearDataSourceKey() {
    	contextHolder.remove();
	}

}