$( document ).ready(function() {
   $.ajax({
      type: "GET", url: PersolnalInfoURL, contentType: ContentTypeValue, dataType: "json",
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
      }
   });

   $.ajax({
      type: "GET", url: HeadersURL, contentType: ContentTypeValue, dataType: "json",
      success: function(headers){
        $('a[href = "#skillset"]').html(headers.skills);
        $('a[href = "#experience"]').html(headers.jobs);
        $('a[href = "#education"]').html(headers.education);
        $('a[href = "#code"]').html(headers.code);
      }
   });

});

$("#contacts").hide();

$('a[href = "#show_contacts"]').tooltip({
  show: { effect: "slideDown", delay: 250 },
  position: { my: "left top", at: "left bottom"}
});

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

$( "#tab-container" ).tabs({
  create: function( event, ui ) { Factory.build(ui.panel.selector); },
  activate: function( event, ui ) {  Factory.build(ui.newPanel.selector);}
}).addClass( "ui-tabs-vertical");
