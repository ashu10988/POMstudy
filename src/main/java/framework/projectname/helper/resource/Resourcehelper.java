package framework.projectname.helper.resource;

public class Resourcehelper {
	
	// this will give path of directory
	public static String getResourcepath(String path)
	{
	    String	basepath =System.getProperty("user.dir");
	    return basepath + path;
	}

public static void main(String[] args) {
	
	String getpath = Resourcehelper.getResourcepath("/src/main/Resources/configfile/log4j.properties");
	System.out.println(getpath);

}	
	
}
