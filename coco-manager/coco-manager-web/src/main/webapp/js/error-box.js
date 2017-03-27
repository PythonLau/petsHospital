/**
 * Created by wild_wolf on 5/28/16.
 */
(function () {

    //var showErrorBox = function (error) {
    //    var _this = $(this);
    //    console.log('show error');
    //    if (_this.hasClass('none')) {
    //        _this.children('span').first().text(error);
    //        _this.removeClass('none');
    //    }
    //};
    //
    //var hideErrorBox = function () {
    //    var _this = $(this);
    //    console.log('hide error');
    //    if (!_this.hasClass('none')) {
    //        _this.addClass('none');
    //    }
    //};

    $('#error-box').find('.close').on('click', function (e) {
         $(this).parent().addClass('none');
    });

    $.fn.extend({
        showErrorBox: function (error) {
            var _this = $(this).children('.error');
            console.log('show error-box');
            if (_this.hasClass('none')) {
                _this.children('span').first().text(error);
                _this.removeClass('none');
            }
        },
        hideErrorBox: function () {
            var _this = $(this).children('.error');
            console.log('hide error-box');
            if (!_this.hasClass('none')) {
                _this.addClass('none');
            }
        }
    });

}());
