package verification;

import org.testng.Assert;

import java.util.List;

public class Verification {
    public static void verifyEquals(List<String> actualLinkTexts, List<String> expectedLinkTexts, String verifyMsg){
        if(actualLinkTexts.isEmpty() || expectedLinkTexts.isEmpty()){
            Assert.fail("[ERR]Actual or Expected is empty!");
        }
        Assert.assertEquals(actualLinkTexts,expectedLinkTexts,verifyMsg);
    }
}
