package POM;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.text.WordUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.collections.Lists;
import com.aventstack.extentreports.Status;
import Pages.SuperTestNG;

public class WHOrdersPOM extends SuperTestNG {
	@FindBy(id ="sendsms")
	private WebElement SendSMS;

	@FindBy(xpath ="(//div[@class='modal-body']//p)[1]")
	private WebElement SMSOrderDetails;

	@FindBy(xpath = "//div[@class='modal-dialog']")
	private WebElement SMSDialog;

	@FindBy(xpath = "(//button[@class='close'])[1]")
	private WebElement DialogClose;

	@FindBy(xpath = "//a[text()='Import Order']")
	private WebElement ImportOrder;

	@FindBy(id = "select_date")
	private WebElement SelectDate;

	@FindBy(id = "inputfile")
	private WebElement fileupload;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement FileSubmit;

	@FindBy(xpath ="//div[contains(@class,'alert')]//b")
	private WebElement SuccessMSG;

	@FindBy(xpath = "//div[@class='icheckbox_flat-green']")
	private WebElement SelectALL;

	@FindBy(xpath = "//a[@data-record-title='Deleting orders']")
	private WebElement DeleteALL;

	@FindBy(xpath = "(//div[@class='modal-footer']//a)[2]")
	private WebElement Delete;

	@FindBy(xpath = "//a[text()='Create Order']")
	private WebElement CreateOrder;

	@FindBy(xpath = "//select[@name='sale_type']")
	private WebElement SelectSaleType;
	
	@FindBys(@FindBy(xpath = "//select[@name='sale_type']//option"))
	List<WebElement> SaleTypes;

	@FindBy(name = "order_no")
	private WebElement OrderNumber;

	@FindBy(name = "web_inv_no")
	private WebElement InvoiceNumber;

	@FindBy(name = "inv_received_date")
	private WebElement ReceivedDate;

	@FindBy(name = "web_inv_date")
	private WebElement WHInvoiceDate;

	@FindBy(name = "inv_qty")
	private WebElement InvoiceQty;

	@FindBy(name = "inv_value")
	private WebElement InvoiceVal;

	@FindBy(name = "no_of_boxes")
	private WebElement Boxes;

	@FindBy(name = "weight_kgs")
	private WebElement Weight;

	@FindBy(name = "distributor_name")
	private WebElement Name;

	@FindBy(name = "distributor_id")
	private WebElement ID;

	@FindBy(name = "distributor_phone")
	private WebElement Phone;

	@FindBy(name = "location")
	private WebElement Location;

	@FindBy(name = "area_pin_code")
	private WebElement PinCode;

	@FindBy(xpath = "//select[@name='state']")
	private WebElement State;

	@FindBy(xpath = "//select[@name='regional_zone_name']")
	private WebElement Regional;

	@FindBy(xpath = "//select[@name='warehouse']")
	private WebElement WareHouse;
	
	@FindBys(@FindBy(xpath = "//select[@name='warehouse']//option"))
	List<WebElement> WareHouses;

	@FindBy(name = "dispatch_dt_from_WH")
	private WebElement DispatchFromWH;

	@FindBy(name = "transporter_name")
	private WebElement Transport;

	@FindBy(name = "docket_no")
	private WebElement Docket;

	@FindBy(xpath = "//select[@name='mode_of_transport']")
	private WebElement TransportMode;

	@FindBy(name = "expected_date_of_delivery")
	private WebElement ExpectedDate;

	@FindBy(name = "actual_delivery_date")
	private WebElement ActualDate;

	@FindBy(name = "received_by")
	private WebElement Received;

	@FindBy(name = "remarks")
	private WebElement Remarks;

	@FindBy(xpath = "//input[@type = 'submit']")
	private WebElement Save;

	@FindBy(name = "search")
	private WebElement Search;

	@FindBy(xpath = "//tr[@class='even pointer']")
	private WebElement SearchedOrder;

	@FindBys(@FindBy(xpath = "//tr"))
	private List<WebElement> Ordrs;

	@FindBy(xpath = "(//tr[@class='even pointer'])[1]")
	private WebElement CreatedOrder;

	@FindBy(xpath = "(//a[contains(@class, 'eye-open')])[1]")
	private WebElement ViewOrder;

	@FindBy(xpath = "(//a[contains(@class, 'edit')])[1]")
	private WebElement EditOrder;

	@FindBy(id = "sale_type")
	private WebElement SaleType;

	@FindBy(id = "order_no")
	private WebElement OrderSO;

	@FindBy(id = "web_inv_no")
	private WebElement InvoicePS;

	@FindBy(id = "inv_received_date")
	private WebElement InvoiceDate;

	@FindBy(id = "web_inv_date")
	private WebElement InvoiceWHRrecievedDate;

	@FindBy(id = "inv_qty")
	private WebElement InvoiceQuantity;

	@FindBy(id = "inv_value")
	private WebElement InvoiceValue;

	@FindBy(id = "no_of_boxes")
	private WebElement NoOfBoxes;

	@FindBy(id = "weight_kgs")
	private WebElement WeightKgs;

	@FindBy(id = "distributor_name")
	private WebElement DistributorName;

	@FindBy(id ="distributor_id")
	private WebElement DistributorIDUPP;

	@FindBy(id = "distributor_phone")
	private WebElement DistributorPhone;

	@FindBy(id = "location")
	private WebElement DistributorLocation;

	@FindBy(id = "area_pin_code")
	private WebElement AreaPinCode;

	@FindBy(id = "state")
	private WebElement AreaState;

	@FindBy(id = "regional_zone_name")
	private WebElement RegionalZoneName;

	@FindBy(id = "warehouse")
	private WebElement Warehouse;

	@FindBy(id = "dispatch_dt_from_WH")
	private WebElement DispatchDate;

	@FindBy(id = "transporter_name")
	private WebElement TransporterName;

	@FindBy(id = "docket_no")
	private WebElement DocketNo;

	@FindBy(id = "mode_of_transport")
	private WebElement ModeOfTransport;

	@FindBy(id = "standard_transit_days")
	private WebElement StandardTransitDays;

	@FindBy(id = "expected_date_of_delivery")
	private WebElement ExpectedDateOfDelivery;

	@FindBy(id = "actual_delivery_date")
	private WebElement ActualDateOfDelivery;

	@FindBy(id = "received_by")
	private WebElement ReceivedBy;

	@FindBy(id = "status")
	private WebElement STATUS;

	@FindBy(id = "ds_team_order_sent_to_wh_tat_days")
	private WebElement WHTATDays;

	@FindBy(xpath ="//a[text()='Back']")
	private WebElement Back;

	@FindBy(xpath ="//input[@value='Update']")
	private WebElement Update;

	@FindBy(xpath ="(//strong[text()])[2]")
	private WebElement NoRecordsFound;


	public WHOrdersPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void SendSMS() throws InterruptedException {
		
		test.log(Status.INFO, "<b><font color=green>Send SMS</font></b>");
		
		SelectALL.click();
		SendSMS.click();
		test.log(Status.INFO, "Send sms: "+ "for Dist ID 108639101: ");
		test.log(Status.INFO, SMSOrderDetails.getText());

		Assert.assertEquals(SMSOrderDetails.getText(), 
				"Total orders selected: 1\nOrders already delivered: 0\nSMS sent successfully: 0\nSMS sent failed: 1");
		DialogClose.click();

		Thread.sleep(5000);
		DeleteALL.click();
		Delete.click();
		test.log(Status.INFO, SuccessMSG.getText());
		Assert.assertEquals(SuccessMSG.getText(), "Selected orders deleted successfully");

		ID.sendKeys("108639101");
		Search.click();
		Assert.assertEquals(NoRecordsFound.getText(), "No Records Found");

		test.log(Status.INFO, "Search"+ "for Dist ID 108639101: ");
		test.log(Status.INFO, NoRecordsFound.getText());
	}

	@SuppressWarnings("deprecation")
	public void ImportOrder() throws InterruptedException, IOException, InvalidFormatException {

		test.log(Status.INFO, "<b><font color=green>Import Orders</font></b>");

		Thread.sleep(5000);
		String excelpath = System.getProperty("user.dir") + "/drivers/sample.xlsx";

		Workbook workbook = WorkbookFactory.create(new File(excelpath));
		Sheet sheet = workbook.getSheetAt(0);

		DataFormatter df = new DataFormatter();
//		ArrayList<String> Val = new ArrayList<>();
		List<String> Val = new ArrayList<String>();
//		ArrayList<String> K = new ArrayList<>();
		List<String> K = new ArrayList<String>();
		List<List<String>> listOfLists = Lists.newArrayList();

		CellAddress columnNumber=null;

		for (Row r : sheet) {
			Cell cellvalue = r.getCell(19);
			if(cellvalue != null && cellvalue.getCellType() != Cell.CELL_TYPE_BLANK && cellvalue.getCellType() != Cell.CELL_TYPE_STRING ) {
				String asItLooksInExcel = df.formatCellValue(cellvalue);
				Val.add(asItLooksInExcel);
				if ("11/Mar/19".equals(asItLooksInExcel)) {
					columnNumber=cellvalue.getAddress();

					int rownumber = columnNumber.getRow() + 1;
					String z = "!"+"A"+rownumber+":"+"AG"+(rownumber);
					AreaReference range = new AreaReference(sheet.getSheetName() + z, SpreadsheetVersion.EXCEL2007);
					CellReference[] cell = range.getAllReferencedCells();
					for (int i=0; i<cell.length; i++) {
						Sheet excel = workbook.getSheet(cell[i].getSheetName());
						Row row = excel.getRow(cell[i].getRow());
						Cell cecllvalue = row.getCell(cell[i].getCol());
						K.add(df.formatCellValue(cecllvalue));
					}
					listOfLists.add(Lists.newArrayList(K));
					K.clear();
				}
			}
		}
		int dispatchDate = Collections.frequency(Val,"11/Mar/19");
		Assert.assertEquals(dispatchDate, listOfLists.size());

		List<List<String>> Orders = Lists.newArrayList();
//		ArrayList<String> insert = new ArrayList<>();
		List<String> insert = new ArrayList<String>();

		for(int j = 0; j<listOfLists.size(); j++) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yy", Locale.ENGLISH);
			final char[] delimiters = { ' ', '_' };
			insert.add(listOfLists.get(j).get(2));
			insert.add(listOfLists.get(j).get(9));
			insert.add(listOfLists.get(j).get(7));
			insert.add(listOfLists.get(j).get(10));
			insert.add(WordUtils.capitalizeFully(listOfLists.get(j).get(14), delimiters));
			insert.add(listOfLists.get(j).get(15));
			insert.add(listOfLists.get(j).get(21));
			insert.add(listOfLists.get(j).get(20));
			insert.add(listOfLists.get(j).get(22));
			insert.add("0");
			insert.add(LocalDate.parse(listOfLists.get(j).get(24), formatter).toString());
			insert.add(LocalDate.parse(listOfLists.get(j).get(19), formatter).toString());
		}
		Orders.add(Lists.newArrayList(insert));
		insert.clear();

//		ArrayList<String> Key = new ArrayList<>();
		List<String> Key = new ArrayList<String>();
		ArrayList<String> Value = new ArrayList<String>(Arrays.asList(
				"Sl No",
				"Sale type",
				"Order No.",
				"Inv No.",
				"Inv Dt",
				"Inv WH Receipts Dt",
				"Order Receipt time in WH",
				"Distribuor ID No",
				"DS / UPP Owner Phone No",
				"Distribuor Name / UPP Name",
				"DS Location Name",
				"State Name",
				"Location PIN Code",
				"Regional Zone Name",
				"Ship From Warehouse",
				"Inv Value",
				"Weight (Kgs)",
				"No of Boxes",
				"Invoice Qty",
				"Dispatch DT from WH",
				"Transporter Name",
				"Docket No",
				"Mode of Transport             ( SURFACE / AIR )",
				"Standard , Transit days",
				"Expected. Date. of Delivery",
				"Actual Delivery Date.",
				"Received By",
				"Status",
				"DS Team Order Sent to WH, TAT Days",
				"WH processing TAT, Days",
				"Courier team Transit (TAT) Delay Days",
				"Actual Order  Delivery TAT",
				"Remarks"));

		AreaReference range = new AreaReference(sheet.getSheetName() + "!A7:AG7", SpreadsheetVersion.EXCEL2007);
		CellReference[] cell = range.getAllReferencedCells();
		for (int i=0; i<cell.length; i++) {
			Sheet excel = workbook.getSheet(cell[i].getSheetName());
			Row row = excel.getRow(cell[i].getRow());
			String cellvalue = row.getCell(cell[i].getCol()).toString();
			Key.add(cellvalue);
		}
		test.log(Status.INFO, "Checking the Excel sheet format");
		Assert.assertEquals(Key, Value);

		ImportOrder.click();
		Thread.sleep(2000);
		SelectDate.sendKeys("03/11/2019");
		test.log(Status.INFO, "Selected Dispatch Date : 03/11/2019" );

		fileupload.sendKeys(excelpath);
		FileSubmit.click();

		test.log(Status.INFO, SuccessMSG.getText());
		Assert.assertEquals(SuccessMSG.getText(), "Excel file uploaded successfully. Total orders uploaded - " + dispatchDate + " | inserted orders - "+ dispatchDate +" | status delivered orders - 0");

		List<List<String>> q = Lists.newArrayList();
//		ArrayList<String> r = new ArrayList<>();
		List<String> r = new ArrayList<String>();
		for(int n = 1; n < Ordrs.size(); n++) {
			for(int k = 2; k < 14; k++) {
				String b = driver.findElement(By.xpath("//tr"+"["+ n +"]"+"//td"+"["+k+"]")).getText();
				r.add(b);
			}
		}
		q.add(Lists.newArrayList(r));
		Assert.assertEquals(Orders, q);
	}

	public void DeleteImportOrder() throws InterruptedException {
		SelectALL.click();
		DeleteALL.click();
		Thread.sleep(5000);
		Delete.click();
		Assert.assertEquals(SuccessMSG.getText(), "Selected orders deleted successfully");
		test.log(Status.INFO, "Delete :"+ SuccessMSG.getText());
	}

	public void CreateOrder() {
		
		test.log(Status.INFO, "<b><font color=407899>"+"Creating Order" + "</font></b>");
		
		CreateOrder.click();

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");

		String[] expected = {
				"Select Sale Types",
				"WEB SALES",	
				"UPP SALES"
		};
		
		for (int i = 0; i < expected.length; i++) 
		{	
			Assert.assertEquals(SaleTypes.get(i).getText(), expected[i]);
		}
		
		Select saletype = new Select(SelectSaleType);
		saletype.selectByVisibleText("WEB SALES");
		OrderNumber.sendKeys("123456789");
		InvoiceNumber.sendKeys("12345");
		ReceivedDate.sendKeys(formatter.format(date));
		WHInvoiceDate.sendKeys(formatter.format(date));
		InvoiceQty.sendKeys("2");
		InvoiceVal.sendKeys("1983.76");
		Boxes.sendKeys("1");
		Weight.sendKeys("1");
		Name.sendKeys("Testing");
		ID.sendKeys("108639101");
		Phone.sendKeys("9019185440");
		Location.sendKeys("Bangalore");
		PinCode.sendKeys("560042");
		Select state = new Select(State);
		state.selectByVisibleText("Karnataka");
		Select regional = new Select(Regional);
		regional.selectByVisibleText("SOUTH");
		
		String[] wh = {
				"Select Warehouse",
				"Bangalore",	
				"Guwahati",
				"Bhiwandi",
				"Ahmedabad",
				"Gurgaon"
		};
		
		for (int i = 0; i < wh.length; i++) 
		{	
			Assert.assertEquals(WareHouses.get(i).getText(), wh[i]);
		}
		
		Select warehouse = new Select(WareHouse);
		warehouse.selectByVisibleText("Bangalore");
		DispatchFromWH.sendKeys(formatter.format(date));
		Transport.sendKeys("DTDC");
		Docket.sendKeys("12345");
		Select transportmode = new Select(TransportMode);
		transportmode.selectByVisibleText("SURFACE");
		ExpectedDate.sendKeys(formatter.format(date));
		ActualDate.sendKeys(formatter.format(date));
		Received.sendKeys("Testing");
		Remarks.sendKeys("Testing Uncity India Ware House Application");
		Save.click();
		Assert.assertEquals(SuccessMSG.getText(), "Order created successfully");

		test.log(Status.INFO, "Create :"+ "Dist ID: 108639101, Order Number: 123456789 , InvoiceNumber: 12345");
		test.log(Status.INFO, SuccessMSG.getText());

		ID.sendKeys("108639101");
		Search.click();
		Assert.assertEquals(CreatedOrder.getText(), "123456789 Testing 108639101 Bangalore Bangalore 1983.76 12345 DTDC SURFACE 0 " + formatter1.format(date) +" " + formatter1.format(date));
		test.log(Status.INFO, "Created Order should be as the 1st Record in the table");

		CreateOrder.click();

		saletype.selectByVisibleText("UPP SALES");
		OrderNumber.sendKeys("887247623");
		InvoiceNumber.sendKeys("2143244");
		ReceivedDate.sendKeys(formatter.format(date));
		WHInvoiceDate.sendKeys(formatter.format(date));
		InvoiceQty.sendKeys("2");
		InvoiceVal.sendKeys("2000.75");
		Boxes.sendKeys("1");
		Weight.sendKeys("1");
		Name.sendKeys("Testing");
		ID.sendKeys("108639101");
		Phone.sendKeys("9019185440");
		Location.sendKeys("Bangalore");
		PinCode.sendKeys("560042");

		state.selectByVisibleText("Karnataka");

		regional.selectByVisibleText("SOUTH");

		warehouse.selectByVisibleText("Guwahati");
		DispatchFromWH.sendKeys(formatter.format(date));
		Transport.sendKeys("DTDC");
		Docket.sendKeys("12345");

		transportmode.selectByVisibleText("SURFACE");
		ExpectedDate.sendKeys(formatter.format(date));
		ActualDate.sendKeys(formatter.format(date));
		Received.sendKeys("Testing");
		Remarks.sendKeys("Testing Uncity India Ware House Application");
		Save.click();
	}

	public void ViewOrder() {
		
		ID.sendKeys("108639101");
		Search.click();
		
		ViewOrder.click();

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		Assert.assertEquals(SaleType.getAttribute("placeholder"), "UPP SALES");
		Assert.assertEquals(OrderSO.getAttribute("placeholder"), "887247623");
		Assert.assertEquals(InvoicePS.getAttribute("placeholder"), "2143244");
		Assert.assertEquals(InvoiceDate.getAttribute("placeholder"), formatter.format(date));
		Assert.assertEquals(InvoiceWHRrecievedDate.getAttribute("placeholder"), formatter.format(date));
		Assert.assertEquals(InvoiceQuantity.getAttribute("placeholder"), "2");
		Assert.assertEquals(InvoiceValue.getAttribute("placeholder"), "2000.75");
		Assert.assertEquals(NoOfBoxes.getAttribute("placeholder"), "1");
		Assert.assertEquals(WeightKgs.getAttribute("placeholder"), "1");
		Assert.assertEquals(DistributorName.getAttribute("placeholder"), "Testing");
		Assert.assertEquals(DistributorIDUPP.getAttribute("placeholder"), "108639101");
		Assert.assertEquals(DistributorPhone.getAttribute("placeholder"), "9019185440");
		Assert.assertEquals(DistributorLocation.getAttribute("placeholder"), "Bangalore");
		Assert.assertEquals(AreaPinCode.getAttribute("placeholder"), "560042");
		Assert.assertEquals(AreaState.getAttribute("placeholder"), "Karnataka");
		Assert.assertEquals(RegionalZoneName.getAttribute("placeholder"), "SOUTH");
		Assert.assertEquals(Warehouse.getAttribute("placeholder"), "Guwahati");
		Assert.assertEquals(DispatchDate.getAttribute("placeholder"), formatter.format(date));
		Assert.assertEquals(TransporterName.getAttribute("placeholder"), "DTDC");
		Assert.assertEquals(DocketNo.getAttribute("placeholder"), "12345");
		Assert.assertEquals(ModeOfTransport.getAttribute("placeholder"), "SURFACE");
		Assert.assertEquals(StandardTransitDays.getAttribute("placeholder"), "3");
		Assert.assertEquals(ExpectedDateOfDelivery.getAttribute("placeholder"), formatter.format(date));
		Assert.assertEquals(ActualDateOfDelivery.getAttribute("placeholder"), formatter.format(date));
		Assert.assertEquals(ReceivedBy.getAttribute("placeholder"), "Testing");
		Assert.assertEquals(WHTATDays.getAttribute("placeholder"), "0");

		Back.click();

		test.log(Status.INFO, "View "+ "Checking the Order Details in view");
	}

	public void EditOrder() {
		

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		ID.sendKeys("108639101");
		Search.click();

		EditOrder.click();

		OrderNumber.clear();
		Name.clear();
		Location.clear();
		InvoiceNumber.clear();
		Docket.clear();
		Transport.clear();

		OrderNumber.sendKeys("98765432");
		Name.sendKeys("Testing India");
		Location.sendKeys("Bangalore South");
		InvoiceNumber.sendKeys("98216362");
		Docket.sendKeys("82153");
		Transport.sendKeys("PROFESSIONAL");

		Update.click();
		Assert.assertEquals(SuccessMSG.getText(), "Order updated successfully");
		
		ID.sendKeys("108639101");
		Search.click();
		
		Assert.assertEquals(SearchedOrder.getText(), "98765432 Testing India 108639101 Bangalore South Guwahati 2000.75 82153 PROFESSIONAL SURFACE 0 " + formatter.format(date) +" " + formatter.format(date));
		test.log(Status.INFO, "Edit "+ "Editing the Order");
		test.log(Status.INFO,  SuccessMSG.getText());
	}

	public void SearchOrder(){

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		ID.sendKeys("108639101");
		Search.click();
		test.log(Status.INFO, "Search :"+ "Distributor ID");
		test.log(Status.INFO, SearchedOrder.getText());
		Assert.assertEquals(SearchedOrder.getText(), "123456789 Testing 108639101 Bangalore Bangalore 1983.76 12345 DTDC SURFACE 0 " + formatter.format(date) +" " + formatter.format(date));

		ID.clear();
		OrderNumber.sendKeys("887247623");
		Search.click();
		test.log(Status.INFO, "Search :"+ "Order ID");
		test.log(Status.INFO, SearchedOrder.getText());
		Assert.assertEquals(SearchedOrder.getText(), "887247623 Testing 108639101 Bangalore Guwahati 2000.75 12345 DTDC SURFACE 0 " + formatter.format(date) +" " + formatter.format(date));

		OrderNumber.clear();
		ID.sendKeys("108639101");
		Select warehouse = new Select(WareHouse);
		warehouse.selectByVisibleText("Guwahati");
		Search.click();
		test.log(Status.INFO, "Search :"+ "Warehouse Guwahati");
		test.log(Status.INFO, SearchedOrder.getText());
		Assert.assertEquals(SearchedOrder.getText(), "887247623 Testing 108639101 Bangalore Guwahati 2000.75 12345 DTDC SURFACE 0 " + formatter.format(date) +" " + formatter.format(date));

		warehouse.selectByVisibleText("Bangalore");
		Search.click();
		test.log(Status.INFO, "Search :"+ "Warehouse Banglore");
		test.log(Status.INFO, SearchedOrder.getText());
		Assert.assertEquals(SearchedOrder.getText(), "123456789 Testing 108639101 Bangalore Bangalore 1983.76 12345 DTDC SURFACE 0 " + formatter.format(date) +" " + formatter.format(date));
	}
}
