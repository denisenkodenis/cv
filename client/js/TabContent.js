function baseBuilder(){}
baseBuilder.prototype.isInitialized = function() { return $(this.panel).html().length > 0; }

function skillSetBuilder(panel){ this.panel = panel; }
skillSetBuilder.prototype = Object.create(baseBuilder.prototype);
baseBuilder.prototype.build = function() {
  panel = this.panel;
  $.ajax( {
       type: "GET", url: SkillsURL, contentType: ContentTypeValue, dataType: "json",
       success: function(data) {
          $.each(data, function(i, item) {
            $(panel).append("<div class='job'>"  + item.name +
                            "</div><div class='job_value'>" + item.description + "</div>");
          });
       }
    })
};

function experienceBuilder(panel){ this.panel = panel; }
experienceBuilder.prototype = Object.create(baseBuilder.prototype);
experienceBuilder.prototype.build = function() {
  panel = this.panel;
  $.ajax({
       type: "GET", url: JobsURL, contentType: ContentTypeValue, dataType: "json",
       success: function(data) {
          $.each(data, function(i, item) {
            $(panel).append(item.duration + "<hr>");
            $(panel).append("<div class='job'>Место</div><div class='job_value'>" + item.company + "</div>");
            $(panel).append("<div class='job'>Должность</div><div class='job_value'>" + item.position + "</div>");
            $(panel).append("<div class='job'>Проекты</div><div class='job_value'>" + item.projects + "</div>");
            $(panel).append("<div class='job'>Описания</div><div class='job_value'>" + item.description + "</div>");
            $(panel).append("<div class='job'>Tехнологии</div><div class='job_value'>" + item.technologies + "</div>");
            $(panel).append("<div class='job'>Обязанности</div><div class='job_value'>" + item.projectrole + "</div>");
          });
       }
    })
};

function educationBuilder(panel){ this.panel = panel; }
educationBuilder.prototype = Object.create(baseBuilder.prototype);
educationBuilder.prototype.build = function() {
  panel = this.panel;
  $.ajax( {
       type: "GET", url: EducationsURL, contentType: ContentTypeValue, dataType: "json",
       success: function(data) {
          $.each(data, function(i, item) {
            $(panel).append(item.time);
            $(panel).append("<hr>")
            $(panel).append("<h3>" + item.academy + "</h3>");
            $(panel).append("<h4>" + item.department + "</h4>");
            $(panel).append(item.diploma);
            $(panel).append("<br>")
          });
       }
    })
};

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

var Factory = {
  build : function(block){
    var builder;
    switch (block) {
      case "#skillset" : { builder = new skillSetBuilder(block); break;}
      case "#experience" : { builder = new experienceBuilder(block); break;}
      case "#education" : { builder = new educationBuilder(block); break;}
      case "#code" : { builder = new codeBuilder(block); break;}
    }
    if (!builder.isInitialized())
      builder.build();
  }
};
