/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-06-15 16:21:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cohortautomation.beans.Survey;
import java.util.*;
import com.cohortautomation.beans.Question;

public final class view_002dsurvey_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
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
      out.write("    <title>View Survey</title>\n");
      out.write("    <style>\n");
      out.write("body {\n");
      out.write("\tfont-family: \"Lato\", sans-serif;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".sidenav {\n");
      out.write("\theight: 100%;\n");
      out.write("\twidth: 25%;\n");
      out.write("\tposition: fixed;\n");
      out.write("\tz-index: 1;\n");
      out.write("\ttop: 0;\n");
      out.write("\tleft: 0;\n");
      out.write("\tbackground-color: #9BB0DA;\n");
      out.write("\toverflow-x: hidden;\n");
      out.write("\tpadding-top: 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".sidenav a {\n");
      out.write("\tpadding: 6px 8px 6px 16px;\n");
      out.write("\ttext-decoration: none;\n");
      out.write("\tdisplay: block;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".sidenav a:hover {\n");
      out.write("\tcolor: #f1f1f1;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".main {\n");
      out.write("\tmargin-left: 25%; /* Same as the width of the sidenav */\n");
      out.write("\tfont-size: 28px; /* Increased text to enable scrolling */\n");
      out.write("\tpadding: 0px 10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("@media screen and (max-height: 450px) {\n");
      out.write("\t.sidenav {\n");
      out.write("\t\tpadding-top: 15px;\n");
      out.write("\t}\n");
      out.write("\t.sidenav a {\n");
      out.write("\t\tfont-size: 18px;\n");
      out.write("\t}\n");
      out.write("}\n");
      out.write("\n");
      out.write(".myFooter {\n");
      out.write("\theight: 50px;\n");
      out.write("\tposition: fixed;\n");
      out.write("\tbottom: 0%;\n");
      out.write("\twidth: 25%;\n");
      out.write("\tbackground-color: #393838;\n");
      out.write("\topacity: 1;\n");
      out.write("}\n");
      out.write("\n");
      out.write("div.scrollmenu {\n");
      out.write("\tbackground-color: #C4C4C4;\n");
      out.write("\toverflow: auto;\n");
      out.write("\twhite-space: nowrap;\n");
      out.write("}\n");
      out.write("\n");
      out.write("div.scrollmenu a {\n");
      out.write("\tdisplay: inline-block;\n");
      out.write("\tcolor: white;\n");
      out.write("\ttext-align: center;\n");
      out.write("\tpadding: 14px;\n");
      out.write("\ttext-decoration: none;\n");
      out.write("}\n");
      out.write("\n");
      out.write("div.scrollmenu a:hover {\n");
      out.write("\tbackground-color: #777;\n");
      out.write("}\n");
      out.write("\n");
      out.write("span {\n");
      out.write("\tfont-size: 20px;\n");
      out.write("\tmargin-right: 5px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("p.cohort-label {\n");
      out.write("\tpadding: 0;\n");
      out.write("\tmargin: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".card-body {\n");
      out.write("\tmin-height: 300px;\n");
      out.write("\tmin-width: 300px;\n");
      out.write("\tmargin-right: 5px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".main {\n");
      out.write("\toverflow: scroll;\n");
      out.write("}\n");
      out.write("\n");
      out.write("::-webkit-scrollbar {\n");
      out.write("\twidth: 0px;\n");
      out.write("\tbackground: transparent;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".myNavLink:hover {\n");
      out.write("\tfont-weight: bold;\n");
      out.write("\tcursor: pointer;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".cohortClass {\n");
      out.write("\tcursor: pointer;\n");
      out.write("\tborder: solid;\n");
      out.write("\tborder-color: #C4C4C4;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".cohortClass:hover {\n");
      out.write("\tborder-color: #fff;\n");
      out.write("}\n");
      out.write("\n");
      out.write("a {\n");
      out.write("\ttext-decoration: none;\n");
      out.write("}\n");
      out.write("</style>\n");
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
      out.write("        <p class=\"myNavLink\" onclick=\"location.href=''\">Attendance</p>\n");
      out.write("        <p class=\"myNavLink\" onclick=\"location.href=''\">Meetings</p>\n");
      out.write("        <p class=\"myNavLink\" onclick=\"location.href=''\">Surveys</p>\n");
      out.write("        <p class=\"myNavLink\" onclick=\"location.href=''\">My Cohort</p>\n");
      out.write("        <hr>\n");
      out.write("        <p class=\"myNavLink\" onclick=\"location.href='/admin-change-password'\">Change Password</p>\n");
      out.write("        <p class=\"myNavLink\">My Profile</p>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"text-center p-3 myFooter\" style=\"background-color: rgba(0, 0, 0, 0.2);\">\n");
      out.write("        <p class=\"mb-2\">Member Dashboard</p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"main px-4\">\n");
      out.write("      <div class=\"text-right mt-2 mr-2\">\n");
      out.write("        <span style=\"font-size: 15px\" class=\"mr-2\">Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.getFullName() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\n");
      out.write("        <a href=\"/logout\"><img src=\"/resources/img/logout.png\" class=\"mt-1\" style=\"width: 15px; height: 15px;\"></a>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("      <small class=\"font-weight-light text-secondary\">\n");
      out.write("      \t<span\n");
      out.write("\t\t\tstyle=\"font-size: 15px;\">\n");
      out.write("\t\t\t <a href=\"/\">Home</a> /\n");
      out.write("\t\t</span> \n");
      out.write("\t\t<span style=\"font-size: 15px;\">\n");
      out.write("\t\t\t View Survey - ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${survey.getSurveyName() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("\t\t</span>\n");
      out.write("\t  </small>\n");
      out.write("\t  \n");
      out.write("\t  <p style=\"font-size: 15px;\" class=\"text-danger\">\n");
      out.write("\t  \tSurvey Deadline - ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${survey.getEndDateTime() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("\t  </p>\n");
      out.write("\t  \n");
      out.write("\t  <div class=\"p-5 mt-3\" style=\"background-color: #C4C4C4;\">\n");
      out.write("        <form action=\"/submit-survey\" method=\"post\">\n");
      out.write("        \t<input type=\"hidden\" name=\"surveyId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${survey.getId() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("        \t");

        		Survey survey = (Survey) request.getAttribute("survey");
        	
        		List<Question> questionsList = survey.getQuestionsList();
        		
        		for(Question question: questionsList){
        			out.print("<label style=\"font-size: 15px;\">"+question.getQuestionText()+"</label>");
        			
        			if(question.getQuestionType().equals("text")){
        				out.print("<input type=\"text\" name=\""+ question.getQuestionType().substring(0,1)+question.getId() +"\" class=\"form-control\" placeholder=\"Answer here\" required>");
        			} else if(question.getQuestionType().equals("number")){
        				out.print("<input type=\"number\" name=\""+ question.getQuestionType().substring(0,1)+question.getId() +"\" class=\"form-control\" placeholder=\"Answer here\" required>");
        			} else {
        				out.print("<input type=\"date\" name=\""+ question.getQuestionType().substring(0,1)+question.getId() +"\" class=\"form-control\" placeholder=\"Answer here\" required>");
        			}
        		}
        	
      out.write("\n");
      out.write("            \n");
      out.write("            <div class=\"text-center mt-3\">\n");
      out.write("\t            ");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("\t  <div class=\"text-right fixed-bottom mr-3\">\n");
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

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t  ");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t  ");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/views/view-survey.jsp(202,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${disable}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t                <button type=\"button\" class=\"btn btn-primary disabled\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Sorry, the survey response are closed now\">Submit Survey</button>\n");
        out.write("\t\t\t\t  ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t                <button type=\"submit\" class=\"btn btn-primary\">Submit Survey</button>\t\n");
        out.write("\t\t\t\t  ");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }
}