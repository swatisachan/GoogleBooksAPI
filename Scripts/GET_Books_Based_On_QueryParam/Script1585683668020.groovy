import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable


List<String> inputKeyNameList= new ArrayList<String>()
Map<String,String> mapToValidate= new HashMap<String,String>()

inputKeyNameList.add("intitle")
inputKeyNameList.add("inpublisher")
inputKeyNameList.add("inauthor")
inputKeyNameList.add("filter")

'Find the list of books based on above parameter'
CustomKeywords.'GoogleBooksAPIKeyword.getBooksByQueryParam'(inputKeyNameList, GlobalVariable.SearchString,mapToValidate)

inputKeyNameList= new ArrayList<String>()
inputKeyNameList.add("id")
'Find the list of books based on Id and Search String'
CustomKeywords.'GoogleBooksAPIKeyword.getBooksByQueryParam'(inputKeyNameList, "Adventures of Sherlock Holmes",mapToValidate)

'Find the book based on isbn no'
inputKeyNameList= new ArrayList<String>()
mapToValidate.put("isbn", "9781678002541")
CustomKeywords.'GoogleBooksAPIKeyword.getBooksByQueryParam'(inputKeyNameList, "Adventures of Sherlock Holmes",mapToValidate)
mapToValidate.remove("isbn")

'Find the book based on filter as paid-ebooks'
mapToValidate.put("filter","paid-ebooks")
CustomKeywords.'GoogleBooksAPIKeyword.getBooksByQueryParam'(inputKeyNameList, "Adventures of Sherlock Holmes",mapToValidate)
mapToValidate.remove("filter")

'Find the book based on the print type as magazines'
mapToValidate.put("printType","magazines")
CustomKeywords.'GoogleBooksAPIKeyword.getBooksByQueryParam'(inputKeyNameList, "Adventures of Sherlock Holmes",mapToValidate)
mapToValidate.remove("printType")

'Find the book based on the projection as Lite'
mapToValidate.put("projection","lite")
CustomKeywords.'GoogleBooksAPIKeyword.getBooksByQueryParam'(inputKeyNameList, "Adventures of Sherlock Holmes",mapToValidate)
mapToValidate.remove("projection")

'Find the book based on orderBy as relevance'
mapToValidate.put("orderBy","relevance")
CustomKeywords.'GoogleBooksAPIKeyword.getBooksByQueryParam'(inputKeyNameList, "Adventures of Sherlock Holmes",mapToValidate)
mapToValidate.remove("orderBy")

'Find the book based on startIndex and maxResult'
inputKeyNameList.add("startIndex")
inputKeyNameList.add("maxResults")
CustomKeywords.'GoogleBooksAPIKeyword.getBooksByQueryParam'(inputKeyNameList, "Adventures of Sherlock Holmes",mapToValidate)
inputKeyNameList.remove("startIndex")
inputKeyNameList.remove("maxResults")

