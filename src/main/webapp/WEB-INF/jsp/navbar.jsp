<ul class="topnav" id="myTopnav">
<li> <a class="active" href="/">Home</a></li>
                <li ><a href="/fhome">Fine Home</a></li>
                 <li ><a href="/addmember">Add Member</a></li>
                 <li ><a href="/viewmembers">View All</a></li>
                 <li ><a href="/feedback">Feedback</a></li>
                <li >
                
<% if(request.session.user){ %>
<a href="/logout">Logout <%=request.session.user.empname%> </a>
<% }else{ %>
<a href="/dologin">Owner Login</a>
<% } %>
</li>
<li class="icon">
    <a href="javascript:void(0);" onclick="myFunction()">☰</a>
  </li>
                </ul>
 
