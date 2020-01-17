
/*Fixed nav bar jquery*/
$(window).on('scroll', function() {
	var wScroll = $(this).scrollTop();
	wScroll > 1 ? $('#naviheader').addClass('fixedNaviBar') : $('#naviheader').removeClass('fixedNaviBar');
	});