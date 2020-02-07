'************************************************************************************************************************************************************
'Generating Xls files for Import
'************************************************************************************************************************************************************

intHighNumberl1 = 100000
intLowNumberl1 = 1
Randomize
intNumberl1 = Int((intHighNumberl1 - intLowNumberl1 + 1) * Rnd + intLowNumberl1)

TERM       = "AUTOTERM_D" & intNumberl1
CRSEID	   = "AUTOCRSEID_D" & intNumberl1
SECTIONID  = "AUTOSECTIONID_D" & intNumberl1
TERMNAME   = "AUTOTERMNAME_D" & intNumberl1
CRSECODE   = "AUTOCOURSECODE_D" & intNumberl1
CRSENAME   = "AUTOCRSENAME_D" & intNumberl1
DEPARTMENT = "AUTODEPARTMENT_D" & intNumberl1
SECTIONCODE = "SECTIONCODE_D" & intNumberl1




Dim objExcel, objWorkbook, fso, fullpath

Set fso = CreateObject("Scripting.FileSystemObject")
fullpath = fso.GetAbsolutePathName("../../../")
Set objExcel = CreateObject("Excel.Application")
Set objWorkbook = objExcel.Workbooks.Open(fullpath & "Murali_LiveText_06-26\Automation_Selenium_April242018\LiveText_POM\Resources\LT_Module_Resources\Files_Excel\Import-Files\LiveText_Courses_Import.xls")
Set c =objWorkbook.worksheets("Sheet1")

objExcel.Cells(2, 1).Value = TERM       
objExcel.Cells(2, 2).Value = CRSEID
objExcel.Cells(2, 3).Value = SECTIONID  
objExcel.Cells(2, 4).Value = TERMNAME   
objExcel.Cells(2, 5).Value = CRSECODE   
objExcel.Cells(2, 6).Value = CRSENAME 
objExcel.Cells(2, 19).Value = DEPARTMENT 

objWorkbook.Save
objworkbook.Close
Set objExcel = Nothing


Dim objExcel1, objWorkbook1, fso1, fullpath1

Set fso1 = CreateObject("Scripting.FileSystemObject")
'fullpath1 = fso1.GetAbsolutePathName(".")
Set objExcel1 = CreateObject("Excel.Application")
Set objWorkbook1 = objExcel1.Workbooks.Open(fullpath & "Murali_LiveText_06-26\Automation_Selenium_April242018\LiveText_POM\Resources\LT_Module_Resources\Files_Excel\Import-Files\LiveText_Student_Roster_Import.xls")
Set c1 =objWorkbook1.worksheets("Sheet1")


objExcel1.Cells(2, 1).Value = TERM       
objExcel1.Cells(2, 2).Value = CRSEID
objExcel1.Cells(2, 3).Value = SECTIONID  

Dim objExcel2, objWorkbook2, fso2, fullpath2

Set fso2 = CreateObject("Scripting.FileSystemObject")
'fullpath2 = fso2.GetAbsolutePathName(".")
Set objExcel2 = CreateObject("Excel.Application")
Set objWorkbook2 = objExcel2.Workbooks.Open(fullpath & "Via_LiveText\Automation_Selenium_April242018\LiveText_POM\Resources\LT_Module_Resources\Files_Excel\Import-Files\hierarchy.csv")
Set c1 =objWorkbook2.worksheets("Sheet1")

objExcel1.Cells(2, 1).Value      
objExcel1.Cells(2, 2).Value
objExcel1.Cells(2, 3).Value 

objWorkbook1.Save
objworkbook1.Close
Set objExcel1 = Nothing






