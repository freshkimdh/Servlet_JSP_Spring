package edu.bit.ex;

public class ViewResolver {
	public String prefix;
	public String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix; // "/"
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix; // ".jsp"
	}
	
	public String getView(String viewName) {
		  return prefix + viewName + suffix;
		  		// "/" + "viewName" + ".jsp"
	}	
}
