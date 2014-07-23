File_Type_Count
===============

This includes the code to list the type of files present in a directory onto an Excel sheet.
===========================================================================================


Currently, the program doesn't work if path is the drive itself (Eg: D:/)
You need to mention a folder's path. (Eg: D:/Movies)

It searches for files/nested files in a given directory/path by taking the extension of the file as input from the user.
The file information is then stored in a HashMap of ArrayList's.

The program uses jxl.jar API which writes data into an Excel Sheet.

It display's the following information in the excel sheet

Module Name,  File Name,  File Type,  File Path,  No of files scanned in same directory


You may wish to give any file extension. (Eg: .avi, .mp3, .mp4, .java, etc)
