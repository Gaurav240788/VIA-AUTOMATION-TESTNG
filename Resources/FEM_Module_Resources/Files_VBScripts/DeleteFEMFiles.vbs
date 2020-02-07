
'*********************************************************************************
'Deleting xls file
'*********************************************************************************


'Delete Mentor File

Dim fullpath
set objFSO = createobject("Scripting.FileSystemObject")
fullpath = objFSO.GetAbsolutePathName("../")
'msgbox fullpath
strFile = fullpath & "\LiveText_POM\Resources\FEM_Module_Resources\Files_MS_Excel\Import_Files\Generated_Files\Mentor3.xls"
'msgbox strFile
objFSO.DeleteFile strFile
set objFSO = Nothing

'Delete Placement File
Dim fullpath1

set objFSO1 = createobject("Scripting.FileSystemObject")
'fullpath1 = objFSO1.GetAbsolutePathName("../")
strFile1 = fullpath & "\LiveText_POM\Resources\FEM_Module_Resources\Files_MS_Excel\Import_Files\Generated_Files\Placement3.xls"
set objFSO1 = createobject("Scripting.FileSystemObject")
objFSO1.DeleteFile strFile1
set objFSO1 = Nothing

'Delete School File
Dim fullpath2

set objFSO2 = createobject("Scripting.FileSystemObject")
'fullpath2 = objFSO2.GetAbsolutePathName(".")
strFile2 = fullpath & "\LiveText_POM\Resources\FEM_Module_Resources\Files_MS_Excel\Import_Files\Generated_Files\School3.xls"
set objFSO2 = createobject("Scripting.FileSystemObject")
objFSO2.DeleteFile strFile2
set objFSO2 = Nothing


'Delete Subject File

Dim fullpath3
set objFSO3 = createobject("Scripting.FileSystemObject")
'fullpath3 = objFSO3.GetAbsolutePathName(".")
strFile3 = fullpath & "\LiveText_POM\Resources\FEM_Module_Resources\Files_MS_Excel\Import_Files\Generated_Files\Subject3.xls"
objFSO3.DeleteFile strFile3
set objFSO3 = Nothing
