/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-05-19 13:20:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_002ddashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("    <!-- Bootstrap CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\" integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    <title>CA - Admin Dashboard</title>\n");
      out.write("    <style>\n");
      out.write("      body {\n");
      out.write("        font-family: \"Lato\", sans-serif;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      .sidenav {\n");
      out.write("        height: 100%;\n");
      out.write("        width: 25%;\n");
      out.write("        position: fixed;\n");
      out.write("        z-index: 1;\n");
      out.write("        top: 0;\n");
      out.write("        left: 0;\n");
      out.write("        background-color: #9BB0DA;\n");
      out.write("        overflow-x: hidden;\n");
      out.write("        padding-top: 20px;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      .sidenav a {\n");
      out.write("        padding: 6px 8px 6px 16px;\n");
      out.write("        text-decoration: none;\n");
      out.write("        display: block;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      .sidenav a:hover {\n");
      out.write("        color: #f1f1f1;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      .main {\n");
      out.write("        margin-left: 25%; /* Same as the width of the sidenav */\n");
      out.write("        font-size: 28px; /* Increased text to enable scrolling */\n");
      out.write("        padding: 0px 10px;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      @media screen and (max-height: 450px) {\n");
      out.write("        .sidenav {padding-top: 15px;}\n");
      out.write("        .sidenav a {font-size: 18px;}\n");
      out.write("      }\n");
      out.write("      .myFooter{\n");
      out.write("        height: 50px; \n");
      out.write("        position: fixed; \n");
      out.write("        bottom:0%;\n");
      out.write("        width:25%; \n");
      out.write("        background-color: #393838; \n");
      out.write("        opacity: 1;\n");
      out.write("      }\n");
      out.write("      div.scrollmenu {\n");
      out.write("        background-color: #C4C4C4;\n");
      out.write("        overflow: auto;\n");
      out.write("        white-space: nowrap;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      div.scrollmenu a {\n");
      out.write("        display: inline-block;\n");
      out.write("        color: white;\n");
      out.write("        text-align: center;\n");
      out.write("        padding: 14px;\n");
      out.write("        text-decoration: none;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      div.scrollmenu a:hover {\n");
      out.write("        background-color: #777;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      span{\n");
      out.write("        font-size: 20px;\n");
      out.write("        margin-right: 5px;\n");
      out.write("      }\n");
      out.write("      p.cohort-label{\n");
      out.write("        padding: 0;\n");
      out.write("        margin: 0;\n");
      out.write("      }\n");
      out.write("      .card-body {\n");
      out.write("        min-height: 300px;\n");
      out.write("        min-width: 300px;\n");
      out.write("        margin-right: 5px;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      .main {\n");
      out.write("        overflow:   scroll;\n");
      out.write("      }\n");
      out.write("      ::-webkit-scrollbar {\n");
      out.write("          width: 0px;\n");
      out.write("          background: transparent;\n");
      out.write("      }\n");
      out.write("      .myNavLink:hover{\n");
      out.write("        font-weight: bold;\n");
      out.write("        cursor: pointer;\n");
      out.write("      }\n");
      out.write("      .cohortClass{\n");
      out.write("        cursor: pointer;\n");
      out.write("        border: solid;\n");
      out.write("        border-color: #C4C4C4;\n");
      out.write("      }\n");
      out.write("      .cohortClass:hover{\n");
      out.write("        border-color: #fff;\n");
      out.write("      }\n");
      out.write("      a{\n");
      out.write("        text-decoration: none;\n");
      out.write("\n");
      out.write("      }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"sidenav\">\n");
      out.write("      <div class=\"text-center\">\n");
      out.write("        <img class=\"img-responsive mb-5\" src=\"/resources/img/logo.png\" style=\"width: 70%;\">\n");
      out.write("\n");
      out.write("        <div class=\"input-group mb-3 p-4\">\n");
      out.write("          <input type=\"text\" class=\"form-control p-3\" placeholder=\"Enter Keywords ..\" aria-label=\"Recipient's username\" aria-describedby=\"basic-addon2\">\n");
      out.write("          <div class=\"input-group-append\">\n");
      out.write("            <span class=\"input-group-text\" id=\"basic-addon2\">&#128269;</span>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"text-left pl-5 pt-3 pr-5\">\n");
      out.write("        <p class=\"myNavLink\" ><strong>Homepage</strong></p>\n");
      out.write("        <p class=\"myNavLink\" onclick=\"location.href='/all-cohort'\">Cohorts</p>\n");
      out.write("        <p class=\"myNavLink\" onclick=\"location.href='/all-sme'\">SMEs</p>\n");
      out.write("        <p class=\"myNavLink\" onclick=\"location.href='/all-mentor'\">Mentors</p>\n");
      out.write("        <p class=\"myNavLink\" onclick=\"location.href='/all-coach'\">Coaches</p>\n");
      out.write("        <p class=\"myNavLink\" onclick=\"location.href='/all-trainer'\">Trainer</p>\n");
      out.write("        <hr>\n");
      out.write("        <p class=\"myNavLink\" onclick=\"location.href='/admin-change-password'\">Change Password</p>\n");
      out.write("        <p class=\"myNavLink\">My Profile</p>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"text-center p-3 myFooter\" style=\"background-color: rgba(0, 0, 0, 0.2);\">\n");
      out.write("        <p class=\"mb-2\">Admin Dashboard</p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"main px-4\">\n");
      out.write("      <div class=\"text-right mt-2 mr-2\">\n");
      out.write("        <span style=\"font-size: 15px\" class=\"mr-2\">Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.getUsername() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\n");
      out.write("        <a href=\"/logout\"><img src=\"/resources/img/logout.png\" class=\"mt-1\" style=\"width: 15px; height: 15px;\"></a>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <p class=\"cohort-label ml-3\" style=\"font-size: 20px\">Cohorts</p>\n");
      out.write("      <div class=\"container-fluid py-2\">\n");
      out.write("        <div class=\"d-flex flex-row flex-nowrap scrollmenu pt-3 pb-2 pl-3 pr-3\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <p class=\"cohort-label ml-3\" style=\"font-size: 20px\">SMEs</p>\n");
      out.write("      <div class=\"container-fluid py-2\">\n");
      out.write("        <div class=\"d-flex flex-row flex-nowrap scrollmenu pt-3 pb-2 pl-3 pr-3\">\n");
      out.write("\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <p class=\"cohort-label ml-3\" style=\"font-size: 20px\">Mentors</p>\n");
      out.write("      <div class=\"container-fluid py-2\">\n");
      out.write("        <div class=\"d-flex flex-row flex-nowrap scrollmenu pt-3 pb-2 pl-3 pr-3\">\n");
      out.write("\t\t  \n");
      out.write("\t\t  ");
      if (_jspx_meth_c_005fforEach_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <p class=\"cohort-label ml-3\" style=\"font-size: 20px\">Coaches</p>\n");
      out.write("      <div class=\"container-fluid py-2\">\n");
      out.write("        <div class=\"d-flex flex-row flex-nowrap scrollmenu pt-3 pb-2 pl-3 pr-3\">\n");
      out.write("\n");
      out.write("\t\t  ");
      if (_jspx_meth_c_005fforEach_005f3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <p class=\"cohort-label ml-3\" style=\"font-size: 20px\">Trainers</p>\n");
      out.write("      <div class=\"container-fluid py-2\">\n");
      out.write("        <div class=\"d-flex flex-row flex-nowrap scrollmenu pt-3 pb-2 pl-3 pr-3\">\n");
      out.write("\t\t  ");
      if (_jspx_meth_c_005fforEach_005f4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("\t  <div class=\"text-right\">\n");
      out.write("\t  \t<p class=\"font-weight-light\" style=\"font-size:15px;\">Last Login: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.getLastLogin() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\n");
      out.write("\t  </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns\" crossorigin=\"anonymous\"></script>\n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/views/admin-dashboard.jsp(158,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("cohort");
    // /WEB-INF/views/admin-dashboard.jsp(158,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/admin-dashboard.jsp(158,3) '${allCohort}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${allCohort}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t            <div class=\"pt-3 px-3 mr-3 bg-white text-center rounded\">\n");
          out.write("\t              <img src=\"/resources/img/group.png\" class=\"img-responsive\" style=\"width: 50px; height: 50px;\">\n");
          out.write("\t              <p style=\"font-size: 15px;\" class=\"text-center mt-2\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cohort.getName() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</p>\n");
          out.write("\t              <button class=\"btn btn-success btn-sm mb-3\">view cohort</button>\n");
          out.write("\t            </div>\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /WEB-INF/views/admin-dashboard.jsp(173,2) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("user");
    // /WEB-INF/views/admin-dashboard.jsp(173,2) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/admin-dashboard.jsp(173,2) '${allSME}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${allSME}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("            <div class=\"pt-3 px-3 mr-3 bg-white text-center rounded\">\n");
          out.write("              <img src=\"/resources/img/profile-user.png\" class=\"img-responsive\" style=\"width: 50px; height: 50px;\">\n");
          out.write("              <p style=\"font-size: 15px;\" class=\"text-center mt-2\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.getFullName() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</p>\n");
          out.write("              <button class=\"btn btn-success btn-sm mb-3\">view profile</button>\n");
          out.write("            </div>\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f2.setParent(null);
    // /WEB-INF/views/admin-dashboard.jsp(188,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setVar("user");
    // /WEB-INF/views/admin-dashboard.jsp(188,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/admin-dashboard.jsp(188,4) '${allMentor}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${allMentor}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f2 = _jspx_th_c_005fforEach_005f2.doStartTag();
      if (_jspx_eval_c_005fforEach_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("            <div class=\"pt-3 px-3 mr-3 bg-white text-center rounded\">\n");
          out.write("              <img src=\"/resources/img/profile-user.png\" class=\"img-responsive\" style=\"width: 50px; height: 50px;\">\n");
          out.write("              <p style=\"font-size: 15px;\" class=\"text-center mt-2\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.getFullName() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</p>\n");
          out.write("              <button class=\"btn btn-success btn-sm mb-3\">view profile</button>\n");
          out.write("            </div>\n");
          out.write("\t\t  ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f2.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f3.setParent(null);
    // /WEB-INF/views/admin-dashboard.jsp(202,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f3.setVar("user");
    // /WEB-INF/views/admin-dashboard.jsp(202,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f3.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/admin-dashboard.jsp(202,4) '${allCoach}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${allCoach}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f3 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f3 = _jspx_th_c_005fforEach_005f3.doStartTag();
      if (_jspx_eval_c_005fforEach_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("            <div class=\"pt-3 px-3 mr-3 bg-white text-center rounded\">\n");
          out.write("              <img src=\"/resources/img/profile-user.png\" class=\"img-responsive\" style=\"width: 50px; height: 50px;\">\n");
          out.write("              <p style=\"font-size: 15px;\" class=\"text-center mt-2\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.getFullName() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</p>\n");
          out.write("              <button class=\"btn btn-success btn-sm mb-3\">view profile</button>\n");
          out.write("            </div>\n");
          out.write("          ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f3.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f3);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f4.setParent(null);
    // /WEB-INF/views/admin-dashboard.jsp(216,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setVar("user");
    // /WEB-INF/views/admin-dashboard.jsp(216,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/admin-dashboard.jsp(216,4) '${allTrainer}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${allTrainer}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f4 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f4 = _jspx_th_c_005fforEach_005f4.doStartTag();
      if (_jspx_eval_c_005fforEach_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("            <div class=\"pt-3 px-3 mr-3 bg-white text-center rounded\">\n");
          out.write("              <img src=\"/resources/img/profile-user.png\" class=\"img-responsive\" style=\"width: 50px; height: 50px;\">\n");
          out.write("              <p style=\"font-size: 15px;\" class=\"text-center mt-2\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.getFullName() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</p>\n");
          out.write("              <button class=\"btn btn-success btn-sm mb-3\">view profile</button>\n");
          out.write("            </div>\n");
          out.write("\t\t  ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f4.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f4);
    }
    return false;
  }
}
