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

Template.getMomentLi = function(memont) {
	var li = $('<li class="comment-item"></li>');
	var textDiv = $('<div class="text">' + memont.text + '</div>');
	li.append(textDiv);
	var imageContainer = $('<div class="image-container"></div>');
	li.append(imageContainer);
	var img;
	var images = memont.images;
	var length = images.length;
	for (var i = 0; i < length; ++i) {
		img = $('<img class="image" src="' + images[i] + '"/>');
		imageContainer.append(img);
	}
	return li;
}