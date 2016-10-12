$(function() {
	var url = window.location.href;
	var lastPart = url.substr(url.lastIndexOf('/') + 1);
	if(lastPart == "download") {
		window.location.href="/downloadSFM";
	}
})