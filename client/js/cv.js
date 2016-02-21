/**
Load PersonalInfo and headers through Ajax immediately after the document is loaded
*/
$( document ).ready(function() {
  loadPersonalInfo();
  loadHeaders();
});
/******************************************************************************/

/**
Init language change link styles
*/
function actualizeLangLinkStyles(){
  if(URLManager.lang == "ru"){
    $("a[href = '#en']").removeClass("inactiveLink");
    $("a[href = '#ru']").removeClass("activeLink");
    $("a[href = '#ru']").addClass("inactiveLink");
    $("a[href = '#en']").addClass("activeLink");
  }else{
    $("a[href = '#ru']").removeClass("inactiveLink");
    $("a[href = '#en']").removeClass("activeLink");
    $("a[href = '#en']").addClass("inactiveLink");
    $("a[href = '#ru']").addClass("activeLink");
  }
};
actualizeLangLinkStyles();
/******************************************************************************/

/**
Hide 'Contacts' block by default
*/
$("#contacts").hide();
/******************************************************************************/

/**
Congigure tooltip for ShowContacts and Pdf buttons
*/
$('a[href = "#show_contacts"]').tooltip({
  show: { effect: "slideDown", delay: 250 },
  position: { my: "left top", at: "left bottom"}
});

$('a[href = "#pdf"]').tooltip({
  show: { effect: "slideDown", delay: 250 },
  position: { my: "right top", at: "right bottom"}
});
/******************************************************************************/

/**
ShowContacts button handler.
*/
$('a[href = "#show_contacts"]').click( function(){
  if(! $("#contacts").is(':visible') )
    $("body, html").animate({scrollTop: 0}, 200);
  $("#contacts").toggle('blind', 400,  function(){
    var imgElement =  $('a[href = "#show_contacts"] img');
    if($("#contacts").is(':visible')) {
   	 imgElement.attr("src", "images/ContactsOff.png");
    }
    else {
   	 imgElement.attr("src", "images/ContactsOn.png");
    }
  });
});
/******************************************************************************/

/**
Change language handlers
*/
function onChangeLanguage(){
  URLManager.changeLanguage();
  actualizeLangLinkStyles();
  loadPersonalInfo();
  loadHeaders();

  $("#skillset").html("");
  $("#experience").html("");
  $("#education").html("");
  $("#code").html("");

  Factory.buildCurrentBlock();
}

$('a[href = "#ru"]').click(onChangeLanguage);
$('a[href = "#en"]').click(onChangeLanguage);
/******************************************************************************/

/**
Print version button handler
*/
$('a[href = "#pdf"]').click( function(){
  window.open(URLManager.pdf());
});
/******************************************************************************/

/**
Init tabs widgit
*/
$( "#tab-container" ).tabs({
  create: function( event, ui ) { Factory.build(ui.panel.selector); },
  activate: function( event, ui ) {  Factory.build(ui.newPanel.selector);}
}).addClass( "ui-tabs-vertical");
/******************************************************************************/

/**
Loading PersonalInfo through Ajax and render recieved data implementation.
*/
function loadPersonalInfo(){
  $.ajax({
     type: "GET", url: URLManager.personalInfo(),
     contentType: ContentTypeValue, dataType: "json",
     success: function(data){
       document.title = data.name;
       $("#Name").html("<h2>" + data.name + "</h2>");
       $("#birthday").html(data.birthDay);
       $("#summary").html("<p>" + data.description + "</p>");
       $("#Mail").html("<a href='mailto:'><p>&nbsp;&nbsp;&nbsp;<img src='images/mail.jpeg' width='16' height='16'>&nbsp;"
                             + data.mail + "</p></a>");

       $("#Skype").html("<a href='skype:'><p><img src='images/skype.jpeg' width='16' height='16'>&nbsp;"
                             + data.skype + "</p></a>");

       $("#Phone").html("<p><img src='images/phone.jpeg' width='16' height='16'>&nbsp;"
                             + data.phone + "</a>");
       $("#city").html(data.city + " @ 2016");
     }
  });
};
/******************************************************************************/

/**
Loading Headers through Ajax and render recieved data implementation.
*/
function loadHeaders(){
  $.ajax({
     type: "GET", url: URLManager.headers(),
     contentType: ContentTypeValue, dataType: "json",
     success: function(headers){
       $('a[href = "#skillset"]').html(headers.skills);
       $('a[href = "#experience"]').html(headers.jobs);
       $('a[href = "#education"]').html(headers.education);
       $('a[href = "#code"]').html(headers.code);
       $('#header_contacts a[href = "#show_contacts"]').attr("title", headers.contacts);
       $('#footer a[href = "#show_contacts"]').html(headers.contacts);
       $('a[href = "#pdf"]').attr("title", headers.print);
     }
  });
};
/******************************************************************************/
