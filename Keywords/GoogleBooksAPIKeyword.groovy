import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.rmi.activation.ActivationGroupDesc.CommandEnvironment

import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class GoogleBooksAPIKeyword {

	public static String bookBaseUrl= GlobalVariable.baseUrl
	public static String apiKey= GlobalVariable.apiKey
	Map<String,String> VolumeMap= GlobalVariable.VolumeMap
	
	
	
	/**
	 * @author: swati
	 * @description: Perform the volume search on 
	 * Google Books API
	 * @param searchString
	 * @param apiKey
	 * @return
	 */
	@Keyword
	def getBooksBySearchString(String searchString){
		'Break the above input string into words appended by +'
		searchString=CommonKeywords.BreakStringIntoWordsAppendedPlus(searchString)
		ResponseObject respObject=WS.sendRequest(findTestObject('Object Repository/GET_Books_By_SearchString_Volumns',[('baseUrl'):bookBaseUrl,('apiKey'):apiKey,('searchQuery'):searchString]))
		
		'Print the response object'
		System.out.println("respObject"+respObject.getResponseBodyContent())
		
		Assert.assertEquals(GlobalVariable.successCode, respObject.getStatusCode())
	}
	
	
	
}
