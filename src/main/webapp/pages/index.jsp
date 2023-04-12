<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Report Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body>
  
    <div class="container">
       <h3 class="pb-3 pt-3" >Report Application!</h3>
        <p><font color="green">${msg}</font></p>
       <form:form action="search" modelAttribute="searchForm" method="POST">
        <table>
         <tr>
           <td>Plan Name: </td>
               <td><form:select path="planName">
                   <form:option value="">-Select -</form:option>
                   <form:options items="${planNamesList}" />
                   </form:select> 
            </td>
            <td>Plan Status: </td>
               <td><form:select path="planStatus">
                   <form:option value="">-Select -</form:option>
                   <form:options items="${planStatusesList}" />
                   </form:select> 
            </td>
            <td>Gender : </td>
            <td>
                <form:select path="gender">
                   <form:option value="">-Select -</form:option>
                   <form:option value="Male">Male</form:option>
                   <form:option value="Fe-Male">Fe-Male</form:option>
                </form:select>    
            </td>
	      </tr>
	      <tr></tr>
	      <tr>
	        <td>Start Date : </td>
	        <td><form:input type="date" path="planStartDate"/>
	        </td>
	        <td>End Date : </td>
	        <td><form:input type="date" path="planEndDate"/></td>
	      </tr>
          <tr></tr>
          <tr>
             <td><a href="/" class="btn btn-secondary">Reset</a></td>
             <td><input type="submit" value="Search" class="btn btn-primary"></td>
          </tr>
	    </table>   
       </form:form> 
       <hr/>
         <table class="table table-striped table-hover">
           <thead>
             <tr>
               <th>S.No</th>
               <th>Holder Name</th>
               <th>Plan Name</th>
               <th>Plan Status</th>
               <th>Gender</th>
               <th>Start Date</th>
               <th>End Date</th>
               <th>Benefit Amt</th>
             </tr>
           </thead>
           <tbody>
            <c:forEach items="${searchList}" var="searchList" varStatus="index">
               <tr>
                 <td>${index.count}</td>
                 <td>${searchList.citizenId}</td>
                 <td>${searchList.planName}</td>
                 <td>${searchList.planStatus}</td>
                 <td>${searchList.gender}</td>
                 <td>${searchList.planStartDate}</td>
                 <td>${searchList.planEndDate}</td>
                 <td>${searchList.benifitAmount}</td>
               </tr>
            </c:forEach>
            <tr>
             <td colspan="8" style="text-align:center"><font color="red"><c:if test="${empty searchList}"> No Records Found </c:if></font></td>
            </tr>
           </tbody>
         </table>
       
       <hr/>
       Export : <a href="/onflyexcel">Excel</a> <a href="/pdfreport">Pdf</a>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>