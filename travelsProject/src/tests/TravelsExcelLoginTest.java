package tests;

import org.testng.annotations.Test;

import pages.TravelsLoginPage;
import utils.ExcelUtils;

public class TravelsExcelLoginTest extends BasicTest {

	@Test(priority = 1)
	public void loginWithExcel() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);

		ExcelUtils ex = new ExcelUtils();
		ex.setExcell("..\\project\\Username.xlsx");
		ex.setWorkSheet(0);

		TravelsLoginPage tlp = new TravelsLoginPage(driver);
		for (int i = 1; i < ex.getRowNumber(); i++) {
			tlp.signIn(ex.getDataAt(i, 0), ex.getDataAt(i, 1));
		}
		ex.closeExcell();
	}
}
