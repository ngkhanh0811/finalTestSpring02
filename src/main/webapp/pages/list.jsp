<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<html>
<head>
    <title>List</title>
    <%@include file="../common/resource.jsp"%>
</head>
<body>
<%@include file="../common/sidebar.jsp"%>
<div class="content bg-gray-100">
    <div class="content-heading flex items-center justify-between p-[20px]">
        <div class="content-heading-title">
            <h3 class="font-medium text-xl">Employees Management</h3>
        </div>
        <div class="content-heading-breadcrumb">
            <ul class="flex items-center text-xs gap-[4px]">
                <li><a href="#">Home </a></li>
                <li> > </li>
                <li><a href="#" class="active"> Employees Management</a></li>
            </ul>
        </div>
    </div>
    <div class="container-fluid flex">
        <div class="content-body bg-white m-[20px] w-[100%] mt-[0] mx-[30px]">
            <div class="flex flex-rows items-center justify-between">
                <button class="p-[12px] m-[12px] border hover:bg-[#f5f5f5]"><a href="/create">Create new employees</a></button>
                <form method="get" action="/employees" class="searchForm flex items-center m-[0] py-[4px]">
                    <input class="outline-0" type="text" placeholder="Search by..." name="searchString" />
                    <button type="submit"><i class="fa-solid fa-magnifying-glass text-black mr-[30px] p-[10px]"></i></button>
                </form>
            </div>
            <table class="m-[20px] mt-[0] w-[97%]">
                <tr class="text-left pl-[20px] h-[52px] border-b">
                    <th class="text-left w-[300px] font-semibold">Employee Name</th>
                    <th class="w-[200px] font-semibold">Salary</th>
                </tr>
                <c:forEach var="item" items="${employees}">
                    <tr class="my-[16px] border-b hover:bg-[#f3f3f3] ease-in-out duration-300">
                        <td class="py-[14px]">${item.name}</td>
                        <td>${item.salary}$</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>





