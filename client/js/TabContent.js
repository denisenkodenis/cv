/**
Base builder prototype for all tab builders
*/
function baseBuilder(){}

/**
Returns was the appropriate builder has already been initialized
*/
baseBuilder.prototype.isInitialized = function() {
  return $(this.panel).html().length > 0;
}
/******************************************************************************/

/**
Builder for SkillSet tab page
*/
function skillSetBuilder(panel){ this.panel = panel; }
skillSetBuilder.prototype = Object.create(baseBuilder.prototype);

/**
Loading SkillSet info through Ajax from REST API and render recieved data implementation.
*/
baseBuilder.prototype.build = function() {
  panel = this.panel;
  $.ajax( {
       type: "GET", url: URLManager.skills(),
       contentType: ContentTypeValue, dataType: "json",
       success: function(data) {
          $.each(data, function(i, item) {
            $(panel).append("<div class='content_header'>"  + item.name +
                            "</div><div class='content_value'>" + item.description + "</div>");
          });
       }
    })
};
/******************************************************************************/

/**
Builder for Experience tab page
*/
function experienceBuilder(panel){ this.panel = panel; }
experienceBuilder.prototype = Object.create(baseBuilder.prototype);

/**
Loading Experience info through Ajax from REST API and render recieved data implementation.
*/
experienceBuilder.prototype.build = function() {
  panel = this.panel;
  $.ajax({
       type: "GET", url: URLManager.jobs(),
       contentType: ContentTypeValue, dataType: "json",
       success: function(data) {
          $.each(data, function(i, item) {
            $(panel).append(item.duration + "<hr>");
            $.each(item.descriptions, function(j, elem) {
              $(panel).append("<div class='content_header'>"  + elem.name +
                              "</div><div class='content_value'>" + elem.description + "</div>");
            });
          });
       }
    })
};
/******************************************************************************/

/**
Builder for Education tab page
*/
function educationBuilder(panel){ this.panel = panel; }
educationBuilder.prototype = Object.create(baseBuilder.prototype);

/**
Loading Education info through Ajax from REST API and render recieved data implementation.
*/
educationBuilder.prototype.build = function() {
  panel = this.panel;
  $.ajax( {
       type: "GET", url: URLManager.educations(), contentType: ContentTypeValue, dataType: "json",
       success: function(data) {
          $.each(data, function(i, item) {
            $(panel).append(item.time);
            $(panel).append("<hr>")
            $(panel).append("<h4>" + item.academy + "</h4>");
            $(panel).append("<h4>" + item.department + "</h4>");
            $(panel).append(item.diploma);
            $(panel).append("<br>")
          });
       }
    })
};
/******************************************************************************/

/**
Builder for Sample Code tab page
*/
function codeBuilder(panel){ this.panel = panel; }
codeBuilder.prototype = Object.create(baseBuilder.prototype);
codeBuilder.prototype.build = function() {
  $(this.panel).append("Исходный код приложения-резюме: <a href='https://github.com/denisenkodenis/cv' targer='_blank'>https://github.com/denisenkodenis/cv</a>");
  $(this.panel).append("<hr>");
  $(this.panel).append("Информация для резюме хранится на сервере в MongoDB. Сервер предоставляет ее через REST API [например <a href='http://denisenkodenis.ru:8080/cv/skills' target='_blank'>denisenkodenis.ru:8080/cv/skills</a>], а так же имеет View для печати PDF [Реализовано на Java Spring].");
  $(this.panel).append("<br>");
  $(this.panel).append("Front end реализован на JQuery UI.");
  $(this.panel).append("<hr>");
};
/******************************************************************************/

/**
The object that creates the appropriate builder depending on the page
*/
var Factory = {
  build : function(block){
    this.currentPage = block;
    var builder;;
    switch (block) {
      case "#skillset" : { builder = new skillSetBuilder(block); break;}
      case "#experience" : { builder = new experienceBuilder(block); break;}
      case "#education" : { builder = new educationBuilder(block); break;}
      case "#code" : { builder = new codeBuilder(block); break;}
    }
    if (!builder.isInitialized())
      builder.build();
  },
  buildCurrentBlock : function(){
    this.build(this.currentPage)
  },
  currentPage : ""
};
/******************************************************************************/
