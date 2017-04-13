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
	return div;
}

Template.getImageImg = function(url) {
	var img = $('<img class="shortcut-image" src="" />');
	img.attr('src', url);
	return img;
}

Template.getImageDel = function(url, targetName, deleteFunc) {
	var img = $('<img class="delete" />');
	img.click(deleteFunc);
	img.attr('src', url);
	img.attr('del', targetName);
	return img;
}