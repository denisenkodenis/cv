const rootUrl = "http://denisenkodenis.ru:8080/cv/"

/**
  Object that returns the current REST URLs, depending on the current language
*/
var URLManager = {
  lang : "ru",
  changeLanguage : function() { this.lang == "ru" ? this.lang = "en" : this.lang = "ru"; },
  personalInfo : function() { return  rootUrl + this.lang + "/personalinfo"; },
  skills : function() { return  rootUrl + this.lang + "/skills"; },
  jobs : function() { return  rootUrl + this.lang + "/jobs"; },
  educations : function() { return  rootUrl + this.lang + "/educations"; },
  headers : function() { return  rootUrl + this.lang + "/headers"; },
  pdf : function() { return  rootUrl + this.lang + "/pdf"; }
}
/******************************************************************************/

const ContentTypeValue = "application/json;charset=utf-8";
