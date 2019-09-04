<%-- 
    Document   : MovieReview
    Created on : 2 Feb, 2019, 8:56:40 PM
    Author     : Nabanita
--%>

<%@page import="controller.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>New York Times Search</title>

        <!-- Bootstrap CSS -->
        <!-- Bootswatch Styling for Improving the Aesthetics -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/flatly/bootstrap.min.css">

        <!-- Font Awesome CSS Icons (For cool glyphicons) -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

        <!-- Style to fix the issue of text extending past panel length -->
        <style>
            .panel-body a 
            {
                word-break:break-all
            }
        </style>
    </head>

    <body>

        <!-- Main Bootstrap Search -->
        <div class="container">

            <!-- Jumbotron for Title -->
            <div class="jumbotron" style="background-color: #20315A ; color: white;">
                <h1 class="text-center"><strong><i class="fa fa-newspaper-o"></i> New York Times Search</strong></h1>
            </div>

            <!-- Row for Searching New York Times -->
            <div class="row">
                <div class="col-sm-12">
                    <br>
                    <!-- First panel is for handling the search parameters -->
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title"><strong><i class="fa  fa-list-alt"></i>Movie Reviews</strong></h3>
                        </div>
                        <div class="panel-body">

                            <!-- Here we create an HTML Form for handling the inputs-->                            
                            <form name="search" method="POST" action="AllReview">                              

                                <div>       
                                    <!--   Getting the list of Movie Reviews From Servlet & Give the newline after each review-->
                                    <%
                                        if ((ArrayList<String>) request.getAttribute("arrayList") != null) {
                                            ArrayList list = (ArrayList<String>) request.getAttribute("arrayList");
                                            try {
                                                boolean first = true;
                                                StringBuilder sb = new StringBuilder();
                                                for (int i = 0; i < list.size(); i++) {
                                                    if (first) {
                                                        first = false;
                                                    } else {
                                                        sb.append("\n");
                                                    }

                                                    sb.append("<li>"+list.get(i).toString()+"<li>");
                                                }
                                                out.println(sb.toString());
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }

                                        }
                                    %>                              
                                </div>
                                <!-- Here we create the text box for searching Movie-->
                                <div class="form-group">
                                    <label for="search">Search Movie:</label>
                                    <input type="text" class="form-control" id="searchTerm" name="Movie">
                                </div>

                                <div>
                                    <!-- Getting Specific Movie Review From Servlet & give the newline after each review -->
                                    <%
                                        if ((ArrayList<String>) request.getAttribute("arrayList1") != null) {
                                            ArrayList list = (ArrayList<String>) request.getAttribute("arrayList1");%>                                 
                                    <% try {
                                                boolean first = true;
                                                StringBuilder sb = new StringBuilder();
                                                for (int i = 0; i < list.size(); i++) {
                                                    if (first) {
                                                        first = false;
                                                    } else {
                                                        sb.append("\n");
                                                    }

                                                    sb.append("<li>"+list.get(i).toString()+"<li>");
                                                }
                                                out.println(sb.toString());
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    %>
                                </div>                                
                                <!-- Here we have our final submit button -->

                                <input type="submit" id="mov" value="Search" onclick="form.action='SpecificReview';"><i class="fa fa-search"></i>

                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- This row will handle all of the retrieved articles -->
            <div class="row">
                <div class="col-sm-12">
                    <br>

                    <!-- This panel will initially be made up of a panel and wells for each of the articles retrieved -->
                    <div class="panel panel-primary">

                        <!-- Panel Heading for the retrieved articles box -->
                        <div class="panel-heading">
                            <h3 class="panel-title"><strong><i class="fa fa-table"></i></strong></h3>
                        </div>


                    </div>
                </div>
            </div>

            <!-- Footer Region -->
            <div class="row">

            </div>
        </div> 

    </body>
</html>