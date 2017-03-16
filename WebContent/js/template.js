/**
 * 
 */

function Template() {

}

Template.basepath = '<c:url value="/"/>';

Template.getImageDiv = function(allowDelete) {
	var div;
	if (allowDelete == true) {
		div = $('<div class="image-element delete-allowed"></div>');
	} else {
		div = $('<div class="image-element"></div>');
	}
	return div[0];
}

Template.getImageImg = function(url) {
	var img = $('<img class="shortcut-image" src="" />')[0];
	img.src = url;
	return img;
}

Template.getImageDel = function(url, name) {
	var img = $('<img class="delete" name="" src="" onclick="deleteImage(this)" />')[0];
	img.src = url;
	img.name = name;
	return img;
}