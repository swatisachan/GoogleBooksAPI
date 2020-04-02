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


	/**
	 * @author: swati
	 * @description: Get the list of books based on single
	 * or multiple query param
	 * @param inputKeyName
	 * @return
	 */
	@Keyword
	def  getBooksByQueryParam(List<String> inputKeyName,String searchString,Map<String,String> mapToValidate){
		Map<String,String> volumeMapGlblVar=GlobalVariable.VolumeMap
		Set<String> glblVarKeySet=volumeMapGlblVar.keySet()
		Iterator<String> itr=glblVarKeySet.iterator()
		'Replace the mapToValidate with Global Var map value'
		while(itr.hasNext()){
			String glblKey=itr.next()
			if(mapToValidate.containsKey(glblKey)){
				volumeMapGlblVar.replace(glblKey, mapToValidate.get(glblKey))
			}
		}

		String queryString=CommonKeywords.frameQueryString(volumeMapGlblVar, inputKeyName)
		searchString=CommonKeywords.BreakStringIntoWordsAppendedPlus(searchString)
		String completeUrl= bookBaseUrl+"/v1/volumes?q="+searchString+"&key="+apiKey+"&"+queryString
		ResponseObject respObject=WS.sendRequest(findTestObject('Object Repository/GET_Books_By_QueryParam',[('completeUrl'):completeUrl]))

		'Print the response object'
		System.out.println("respObject"+respObject.getResponseBodyContent())
		Assert.assertEquals(GlobalVariable.successCode, respObject.getStatusCode())
	}

	/**
	 * @author: swati
	 * @description: Get the list of user
	 * public book shelves
	 * @return
	 */
	@Keyword
	def getlistOfUserPublicBookShelves(){
		ResponseObject respObject=WS.sendRequest(findTestObject('Object Repository/GET_getlistOfUserPublicBookShelves',[('baseUrl'):bookBaseUrl,('userId'):GlobalVariable.uid,('apiKey'):apiKey]))

		'Print the response object'
		System.out.println("respObject"+respObject.getResponseBodyContent())
		Assert.assertEquals(GlobalVariable.successCode, respObject.getStatusCode())
	}

	/**
	 * @author: swati
	 * @description: Retrieve a particular book shelf based on book shelf ID
	 * @param shelfId
	 * @return
	 */
	@Keyword
	def getPublicBookShelvesBasedOnBookShelfID(String shelfId){
		ResponseObject respObject=WS.sendRequest(findTestObject('Object Repository/GET_PublicBookShelvesBasedOnBookShelfID',[('baseUrl'):bookBaseUrl,('userId'):GlobalVariable.uid,('apiKey'):apiKey,('shelfId'):shelfId]))

		'Print the response object'
		System.out.println("respObject"+respObject.getResponseBodyContent())
		Assert.assertEquals(GlobalVariable.successCode, respObject.getStatusCode())
	}

	/**
	 * @author: swati
	 * @description: Get the list of volumes
	 * for public bookShelves
	 * @param shelfId
	 * @return
	 */
	@Keyword
	def getListOfVolPublicBookShelves(String shelfId){
		ResponseObject respObject=WS.sendRequest(findTestObject('Object Repository/GET_ListOfVolPublicBookShelves',[('baseUrl'):bookBaseUrl,('userId'):GlobalVariable.uid,('apiKey'):apiKey,('shelfId'):shelfId]))

		'Print the response object'
		System.out.println("respObject"+respObject.getResponseBodyContent())
		Assert.assertEquals(GlobalVariable.successCode, respObject.getStatusCode())
	}
}


