import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class CommonKeywords {


	/**
	 * @author: swati
	 * @description: Break the string into words
	 * appended by '+' operator
	 * @param inputString
	 * @return
	 */
	def static BreakStringIntoWordsAppendedPlus(String inputString){
		List<String> listOfWords=inputString.split(" ")
		String finalString=""
		Iterator<String> itr=listOfWords.iterator()
		int count=0
		while(itr.hasNext()){
			String eachWord=itr.next()
			count=count+1
			if(count== listOfWords.size())
				finalString= finalString+eachWord
			else
				finalString=finalString+eachWord+"+"
		}
		return finalString
	}

	/**@author: swati
	 * @description: Frame the query Url
	 * @param glblVarUrl
	 * @param inputMapUrl
	 * @return
	 */
	def static frameQueryString(Map<String,String> glblVarUrl, List<String> inputKeys){
		Set<String> glblKeySet=glblVarUrl.keySet()
		String finalQueryUrl=""
		Iterator<String> glblKeys=glblKeySet.iterator()
		int count=0
		while(glblKeys.hasNext()){
			String glblKey=glblKeys.next()
			if(inputKeys.contains(glblKey)){
				String value= glblVarUrl.get(glblKey)
				value=BreakStringIntoWordsAppendedPlus(value)
				count=count+1
				if(count==inputKeys.size())
					finalQueryUrl=finalQueryUrl+glblKey+"="+value
				else
					finalQueryUrl=finalQueryUrl+glblKey+"="+value+"&"
			}
		}
		return finalQueryUrl
	}
}
