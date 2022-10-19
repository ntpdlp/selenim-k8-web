package driver;

public enum BrowserType {
    chrome("chrome"),
    firefox("firefox"),
    safari("safari");

    private String name;

    BrowserType(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
