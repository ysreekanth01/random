package com.wellbee.doctorsPractice;

public class Partice4 {

	
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.util.List;
	import java.util.Properties;
	import java.util.Random;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.canossa.genericUtility.ExecelUtility;
	import com.canossa.genericUtility.PropertyFileUtility;
	import com.canossa.genericUtility.IConstantPath;
	import com.canossa.genericUtility.JavaLibrary;
	import com.canossa.genericUtility.PropertyFileKeys;
	import com.canossa.genericUtility.PropertyFileUtility;
	import com.canossa.genericUtility.SheetName;
	import com.canossa.genericUtility.WebDriverUtility;
import com.canossa.objectRepository.AddDoctor;
import com.canossa.objectRepository.Doctor;
//import com.canossa.objectRepository.DoctorSpecialization;
import com.canossa.objectRepository.DoctorSpecializationPage;
import com.canossa.objectRepository.LoginPage;
import com.canossa.objectRepository.ManageDoctorsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class NewAddingDoctorTest2 {

		public static void main(String[] args) throws Exception {
				



			
			PropertyFileUtility fu=new PropertyFileUtility();
			fu.openPropertyFile(IConstantPath.PROPERTY_PATH);
			String url1=fu.getPropertyFileData(PropertyFileKeys.URL.convertToString());
			String browser1 =fu.getPropertyFileData(PropertyFileKeys.BROWSER.convertToString());
			String timeout=fu.getPropertyFileData(PropertyFileKeys.TIMEOUT.convertToString());
			
			JavaLibrary jv=new JavaLibrary();
			Long sec = (Long) jv.converStringToNumeric(timeout, "long");
			


			ExecelUtility eu=new ExecelUtility();
			
			String expectedSpecialization=eu.getDataFromExcel(IConstantPath.EXCEL_PATH,SheetName.DOCTOR.convertToString(),3,2);
	
			String email=eu.getDataFromExcel(IConstantPath.EXCEL_PATH,SheetName.DOCTOR.convertToString(), 4, 2);
			
			WebDriverUtility webDriverUtility= new WebDriverUtility();
			
			 WebDriver driver = webDriverUtility.launchApplication(browser1,sec, url1);
		
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
			driver.get(url1);


			String data=eu.getDataFromExcel(IConstantPath.EXCEL_PATH,SheetName.DOCTOR.convertToString(), 2, 2);

//			driver.findElement(By.xpath("//a[@href='hms/admin']")).click();
		
			String un=fu.getPropertyFileData(PropertyFileKeys.USERNAME.convertToString());
//
//			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un);
//			
//			
			String pwd=fu.getPropertyFileData(PropertyFileKeys.PASSWORD.convertToString());
//			System.out.println(pwd);
//			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
//			
//			driver.findElement(By.name("submit")).click();
			
			LoginPage lp=new LoginPage(driver);
			lp.loginAction(un, pwd);
			
			Doctor doc=new Doctor(driver);
			doc.clickDoctor();
			
			
			

		
			//driver.findElement(By.xpath("//span[text()=' Doctors '] ")).click();
			
//			driver.findElement(By.xpath("//span[text()=' Doctor Specialization ']")).click();
//			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(data);
//			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			DoctorSpecializationPage ds=new DoctorSpecializationPage(driver);
			ds.addDoctorSpecialization(data);
		List<WebElement> special = ds.getSpecializations();
			for(WebElement webElements:special) {
				
				String actualSpecializationName=webElements.getText();
				
				if(actualSpecializationName.equals(expectedSpecialization)) {
					System.out.println("Specialization Added Successfully");
					break;
				}
			}

//		List<WebElement> specializations = driver.findElements(By.xpath("//table[@id='sample-table-1']/tbody/tr/td[@class='hidden-xs']"));
//			for(WebElement webElements:specializations) {
//				String actualSpecializationName=webElements.getText();
//				if(actualSpecializationName.equals(expectedSpecialization)) {
//					System.out.println("Specialization Added Successfully");
//					break;
//				}
//		}

		//	Thread.sleep(3000);
//			WebDriverWait wait = new WebDriverWait(driver,30);
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='panel-body']/p"))).click();
			 
//			webDriverUtility.explicitWait("//div[@class='panel-body']/p", "presenceOfElementLocated");
//			driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
//			driver.findElement(By.xpath("//a[@href='add-doctor.php']")).click();
//			driver.findElement(By.xpath("//select[@name='Doctorspecialization']")).click();
			
			//AddDoctor ad=new AddDoctor(driver);
			//ad.addDoctor();

			List<WebElement> allSpecs = driver.findElements(By.xpath("//option"));
			for(WebElement as:allSpecs)
			{
				String specialization=as.getText();	
				if(specialization.equals(data)) {
					as.click();


				}


		//	}
			//String DoctorName=workbook.getSheet("Sheet1").getRow(5).getCell(2).getStringCellValue();
			String doctorName=eu.getDataFromExcel("./src/test/resources/ExpectedDataSpecialization.xlsx",SheetName.DOCTOR.convertToString(), 4, 2);
			
			//driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Name']")).sendKeys(DoctorName);
			//driver.findElement(By.xpath("//textarea[@name='clinicaddress']")).sendKeys("Btm layout, Bangalore");
			//driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Consultancy Fees']")).sendKeys("1200");
			//driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Contact no']")).sendKeys("9876543210");
			//Random rb=new Random();
			//int ran = rb.nextInt(1000);
			//driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Email id']")).sendKeys(email+ran);
			//driver.findElement(By.xpath("//input[@placeholder='New Password']")).sendKeys("sreekanth");
			//driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys("sreekanth");
			//driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			String docAddress=fu.getPropertyFileData(PropertyFileKeys.DOCTOR_ADDRESS.convertToString());
			String docFee=fu.getPropertyFileData(PropertyFileKeys.DOCTOR_FEES.convertToString());
			String docContact=fu.getPropertyFileData(PropertyFileKeys.DOCTOR_CONTACT.convertToString());
			String docNewPwd=fu.getPropertyFileData(PropertyFileKeys.DOCTOR_NEW_PASSWORD.convertToString());
			String docConfirmPwd=fu.getPropertyFileData(PropertyFileKeys.DOCTOR_CONFIRM_PASSWORD.convertToString());
			String docEmailID=fu.getPropertyFileData(PropertyFileKeys.DOCTOR_EMAIL.convertToString());
			AddDoctor ad1=new AddDoctor(driver);
			ad1.addDoctor(doctorName,docAddress, docFee, docContact,docEmailID, docNewPwd, docConfirmPwd , data);
			

//			WebDriverWait wait1=new WebDriverWait(driver,10);
//			wait.until(ExpectedConditions.alertIsPresent());
			

			Alert a = driver.switchTo().alert();
			a.accept();
			


			List<WebElement> validation = driver.findElements(By.xpath("//tbody/tr/td[3]"));
			for(WebElement vd:validation) {
				String text = vd.getText();

				if(text.equals(doctorName)) {
					System.out.println("Sucessfully doctor added");
					//workbook.getSheet("Sheet1").getRow(1).getCell(4).setCellValue("Pass");
					//eu.setDataToExcel("pass",3,4);
				}
//				else
//				{
//					eu.setDataToExcel("fail",3,4);
//				}
			}
			//workbook.write(fos);
			Thread.sleep(5000);
			
/*				List<WebElement> docNames = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
					List<WebElement> edit = driver.findElements(By.xpath("//table/tbody/tr/td[5]//i[@class='fa fa-pencil']"));
					String expeDocName=doctorName;
					
					for(int i=0;i<docNames.size();i++)
					{
						String actualDocName = docNames.get(i).getText();
					
						if(expeDocName.equals(actualDocName)) {
							edit.get(i).click();
						}
						
					}
					*/
			
		
			ManageDoctorsPage mdp=new ManageDoctorsPage(driver);
			String PartialXpath=mdp.getXpath();
		
			WebElement elem = mdp.StringToWebElement(PartialXpath, "Anuj");
			 elem.click();
			Thread.sleep(5000);
				 WebElement fee = driver.findElement(By.xpath("//input[@name='docfees']"));
				 fee.click();
				Robot r=new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_A);
				fee.sendKeys("800");
				
				r.keyRelease(KeyEvent.VK_CONTROL);
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				//eu.setDataToExcel("pass",2,4);
				//workbook.getSheet("Sheet1").getRow(1).getCell(4).setCellValue("Pass");
				
				
			
				driver.findElement(By.xpath("//span[@class='username']")).click();
				driver.findElement(By.xpath("//a[@href='logout.php']")).click();
				



		}
	

}}


}
