<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    Phase-1 Assessment Project
</head>
<body>
    <h1>LockedMe.com</h1>
    <hr>
    <h2>Table of contents</h2> 
    <ul>
        <li><a href="#Links">Usefull Links</a></li>
        <li><a href="#Intro">Project Introduction</a></li>
        <li><a href="#DevDetails">Developer details</a></li>
        <li><a href="#Sprints">Sprints planned</a></li>
        <li><a href="#Flowchart">Flowchart</a></li>
        <li><a href="#TechUsed">Technologies Used</a></li>
        <li><a href="#CoreConcepts">Core Concepts in project</a></li>
        <li><a href="#Conclusion">Conclusion</a></li>
    </ul>
    <hr>
    <h2><a id="Links">Usefull Links</a></h2>
        <h3>Link for java program to execute application:</h3>
            <a href="https://github.com/NithinNetha/LockedMe/blob/master/src/locked/me/Home.java"> Click here to view Home.java file</a>
            <p>code can also be be found in "src/locked/me/Home.java" path from above commited folders</p>
        <h3>Document with screen shots and explaination:</h3>
            <a href="https://docs.google.com/document/d/15lCVm73rMM3oL6fB-4XV1uJR5QgzdLLYsclsdxtg608/edit?usp=sharing"> Click here to view Document with screenshots</a>
            <p>I tried to cover almost all operations including outputs for invalid inputs<p/>
    <hr>
    <h2><a id="Intro">Project Introduction</a></h2>
        <p>This is simple File Handling project which mainly deals with file names rather than file content.</p>
    <hr>
    <h2><a id="DevDetails">Developer Details</a></h2>
        <p>Project developed by <strong>Palarapu Nithin Kumar</strong> (email_Id : nithin6425@gmail.com) for Phase-1 Assessment</p>
    <hr>
    <h2><a id="Sprints">Sprints planned</a></h2>
        <p>Sprints are planned and updated using <strong>Trello</strong>, click on link given below </p>
        <a href="https://trello.com/b/BcstVBK5/agile-sprint-board" target="_blank">https://trello.com/b/BcstVBK5/agile-sprint-board</a>
        <h3>List of Sprints</h3>
        <ul>
            <li>Draw Flowchart</li>
            <li>Create Welcome Note and Main Menu</li>
            <li>Create Secondary Menu</li>
            <li>AddFile();</li>
            <li>DisplayFile();</li>
            <li>DeleteFile();</li>
            <li>SearchFile();</li>
        </ul>
    <p>All the above sprints are visible in Trello in <strong>"Sprint - Complete" TaskCard</strong> and each individual Card will have comments for reference.</p>
    <hr>
    <h2><a id="Flowchart">Flowchart</a></h2>
    <img style=" display: block; margin-left: auto;margin-right: auto; width: 70%;" src="https://embed.creately.com/IoPaXVdwWdB?type=svg" alt="image not loading https://embed.creately.com/IoPaXVdwWdB?type=svg try with this link">
    <hr>
    <h2><a id="TechUsed">Technologies Used</a></h2>
        <ul>
            <li>Java</li>
            <li>Eclipse IDE</li>
        </ul>
    <hr>
    <h2><a id="CoreConcepts">Core Concepts in project</a></h2>
    <p>Along  with basic concepts of Java like Output stmts, keyboard input, object, for loop, if statements and more, I also used:-</p>
    <ul style="list-style-type:none;">
            <li><p><strong>File class:</strong> to deal with file operations like creating, deleteing files and retrive file names.</p></li>
            <li><p><strong>ArrayList:</strong> to store file names and do operations like Sorting, Display and Searching.</p></li>
            <li><p><strong>getPath():</strong> To get the program path and set the file path according to it.</p></li>
            <li><p><strong>Exceptions:</strong> To catch Exceptions, to deal with invalid inputs which helped to avoid unexcpected termination in application</p></li>
            <li><p><strong>switch():</strong> This is used to operate the program in way user choose.</p></li>
            <li><p><strong>boolean matches():</strong> This regex method is used to find if file name is in proper format.</p></li>
            <li><p><strong>Selection Sort:</strong> to sort file names in ArrayList before displaying.</p></li>
            <li><p><strong>Naive String Search Algorithm:</strong> to search file names in ArrayList in way it can find and display files file names even user enters just name without extension.</p></li>
    </ul>
    <hr>
    <h2><a id="Conclusion">Conclusion</a></h2>
         <p>This LockedMe.com application's unique points are:</p>
        <ul>
            <li> <p>If user gives file name in a format like '.classpath, src, or file.' while creating file, application will not take it as valid input. File names must be "**.***" format only for creating file.</p>
            <img src="https://github.com/NithinNetha/assess1/blob/master/createError.jpg"></li> 
            <li><p> While user wants to search for file, along with normal file name format user can give just the file name without extension and application will show us all the files with same name and differnt extension.  </p>
            <img src="https://github.com/NithinNetha/assess1/blob/master/searchtwo.JPG"></li>
        </ul>
        <p>Hence I conclude this application is designed in a way that user no need to worry about invalid inputs or abnormal termination.</p>
    <h1>Thank you</h1>

       
</body>
</html>
