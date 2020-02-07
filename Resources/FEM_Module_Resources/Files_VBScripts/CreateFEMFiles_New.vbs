'End Row number 

m=6
Dim Subjectarr1(6)
Dim Schoolarr1(6)
Dim Subjectarr2(6)
Dim Schoolarr2(6)
Dim Subjectarr3(6)
Dim Schoolarr3(6)

'************************************************************************************************************************************************************
'Generating Xls files for Import
'************************************************************************************************************************************************************

'Create Mentor

Dim objExcel, objWorkbook, fso, fullpath, parentfolderpath

Set fso = CreateObject("Scripting.FileSystemObject")
fullpath = fso.GetAbsolutePathName("../") 'old value
'fullpath = fso.GetAbsolutePathName(".") 'old value
'MsgBox fullpath 

Set objExcel = CreateObject("Excel.Application")
'Set objWorkbook = objExcel.Workbooks.Open(fullpath & "\Files_MS_Excel\Import_Files\Templates\Mentor.xls")
Set objWorkbook = objExcel.Workbooks.Open(fullpath & "\LiveText_POM\Resources\FEM_Module_Resources\Files_MS_Excel\Import_Files\Templates\Mentor.xls")

For i  = 2 to m
intHighNumberl1 = 100000000
intLowNumberl1 = 1
Randomize
intNumberl1 = Int((intHighNumberl1 - intLowNumberl1 + 1) * Rnd + intLowNumberl1)
ShcoolName = "SchoolName" & intNumberl1
Schoolarr1(i)=ShcoolName 
SubjectName = "SubjectName" & intNumberl1
Subjectarr1(i)=SubjectName
FirstName = "MentorFirst" & intNumberl1
LastName = "MentorLast" & intNumberl1
EmailInstitution = "Institution" & intNumberl1 & "@gmail.com"
objExcel.Cells(i, 1).Value = FirstName
objExcel.Cells(i, 2).Value = LastName
objExcel.Cells(i, 6).Value = EmailInstitution
objExcel.Cells(i, 13).Value = ShcoolName 
objExcel.Cells(i, 19).Value = SubjectName
Next
objExcel.ActiveWorkBook.SaveAs (fullpath & "\LiveText_POM\Resources\FEM_Module_Resources\Files_MS_Excel\Import_Files\Generated_Files\Mentor3.xls")
objworkbook.Close
objExcel.Quit
Set objworkbook= Nothing
Set objExcel = Nothing



'Creating Placement

Dim objExcel1, objWorkbook1, fso1, fullpath1

Set fso1 = CreateObject("Scripting.FileSystemObject")
fullpath1 = fso1.GetAbsolutePathName("../")
Set objExcel1 = CreateObject("Excel.Application")
Set objWorkbook1 = objExcel1.Workbooks.Open(fullpath & "\LiveText_POM\Resources\FEM_Module_Resources\Files_MS_Excel\Import_Files\Templates\Placement.xls")
For i  = 2 to m
ShcoolName = Schoolarr1(i)
SubjectName = Subjectarr1(i)
objExcel1.Cells(i, 1).Value = ShcoolName 
objExcel1.Cells(i, 2).Value = SubjectName
Next
objExcel1.ActiveWorkBook.SaveAs (fullpath & "\LiveText_POM\Resources\FEM_Module_Resources\Files_MS_Excel\Import_Files\Generated_Files\Placement3.xls")
objworkbook1.Close
objExcel1.Quit
Set objworkbook1= Nothing
Set objExcel1 = Nothing



'Creating School

Dim objExcel2, objWorkbook2, fso2, fullpath2

Set fso2 = CreateObject("Scripting.FileSystemObject")
fullpath2 = fso2.GetAbsolutePathName("../")
Set objExcel2 = CreateObject("Excel.Application")
Set objWorkbook2 = objExcel2.Workbooks.Open (fullpath & "\LiveText_POM\Resources\FEM_Module_Resources\Files_MS_Excel\Import_Files\Templates\School.xls")
For i  = 2 to m
ShcoolName = Schoolarr1(i)
SubjectName = Subjectarr1(i)
objExcel2.Cells(i, 1).Value = ShcoolName 
objExcel2.Cells(i, 10).Value = SubjectName
Next
objExcel2.ActiveWorkBook.SaveAs (fullpath & "\LiveText_POM\Resources\FEM_Module_Resources\Files_MS_Excel\Import_Files\Generated_Files\School3.xls")
objworkbook2.Close
objExcel2.Quit
Set objworkbook2= Nothing
Set objExcel2 = Nothing





'Creating Subject

Dim objExcel3, objWorkbook3, fso3, fullpath3
Set fso3 = CreateObject("Scripting.FileSystemObject")
fullpath3 = fso3.GetAbsolutePathName("../")
Set objExcel3 = CreateObject("Excel.Application")
Set objWorkbook3 = objExcel3.Workbooks.Open(fullpath & "\LiveText_POM\Resources\FEM_Module_Resources\Files_MS_Excel\Import_Files\Templates\Subject.xls")
For i  = 2 to m
SubjectName = Subjectarr1(i)
objExcel3.Cells(i, 1).Value = SubjectName
Next
objExcel3.ActiveWorkBook.SaveAs (fullpath & "\LiveText_POM\Resources\FEM_Module_Resources\Files_MS_Excel\Import_Files\Generated_Files\Subject3.xls")
objworkbook3.Close
objExcel3.Quit
Set objworkbook3= Nothing
Set objExcel3 = Nothing






