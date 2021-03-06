;
(function($) {
	var p = {
		cache : {}
	};
	p.M = function(cfg, data) {
		this.$d = cfg.$d;
		this.flag = cfg.flag;
		this.id = this.$d[0].id;
		this.text = cfg.text || true;
		this.speed = parseInt(cfg.speed) || 5000;
		this.hoverStop = cfg.hoverStop;
		this.type = cfg.type || 1;
		this.place = cfg.place || 'fi_tabRB';
		this.myHtml = cfg.myHtml || "";
		this.ptStepX = cfg.ptStepX || 92;
		this.ptStepY = cfg.ptStepY || 81;
		this.ptStepX_ = cfg.ptStepX_ || 4;
		this.ptStepY_ = cfg.ptStepY_ || -1;
		this.focusData = data;
		this.clickTabToNav = cfg.clickTabToNav || false;
		this.autoPlay;
		this.autoPlay1;
		this._fiObj;
		this._$tabC = null;
		this._$tabs = null;
		this._$titleC = null;
		this._$img = null;
		this._$transparentOvl = null;
		this._$desc = null;
		this._$pointer = null;
		this._curData = null;
		this._cfg = cfg;
		this.$d.data("apple", {
			a : cfg,
			b : data
		});
		this.init();
	};
	p.M.prototype = {
		init : function() {
			this._fiObj = p.cache[this.flag];
			if (!this._fiObj)
				return;
			this._fiObj.init(this);
			if (this._cfg.afterInit) {
				this._cfg.afterInit(this);
			}
			;
			this.$d.find(".fi_ct").append(this.myHtml);
			this.spring();
		},
		spring : function() {
			var that = this;
			var gogo = function(i) {
				var _index = i || 0;
				that.alternation(_index);
				that.autoPlay = setInterval(
						function() {
							that
									.alternation((++_index) == that.focusData.length ? _index = 0
											: _index);
						}, that.speed);
			};
			gogo();
			this._$tabs
					.each(function(i) {
						(function(i, o) {
							o = jQuery(o).click(function() {
								if (this.className != "now") {
									clearTimeout(that.autoPlay1);
									clearInterval(that.autoPlay);
									gogo(i);
								}
								;
								if (that.clickTabToNav) {
									window.open(that.focusData[i].l);
								}
								;
								return false;
							});
							if (that.hoverStop) {
								o
										.mouseenter(function() {
											clearInterval(that.autoPlay);
											clearTimeout(that.autoPlay1);
											if (this.className != "now") {
												that.alternation(i);
											}
											;
											return false;
										})
										.mouseleave(
												function() {
													clearInterval(that.autoPlay);
													clearTimeout(that.autoPlay1);
													var j = (i + 1) == that.focusData.length ? 0
															: (i + 1);
													that.autoPlay1 = window
															.setTimeout(
																	function() {
																		gogo(j);
																	},
																	that.speed);
												});
							}
							;
						})(i, this)
					});
			if (this._fiObj.initEvts) {
				this._fiObj.initEvts(this, gogo);
				if (this._cfg.afterInitEvts) {
					this._cfg.afterInitEvts(this);
				}
				;
			}
			;
		},
		alternation : function(i) {
			var continueCommon = true;
			this._curData = this.focusData[i];
			this.$d.data("curData", this._curData);
			if (this._fiObj.alt)
				continueCommon = this._fiObj.alt(this, i);
			if (!continueCommon) {
				if (this._cfg.afterAlt) {
					this._cfg.afterAlt(this);
				}
				;
				return;
			}
			;
			this._$img.attr({
				"src" : this._curData.p,
				"link" : this._curData.l
			}).css({
				opacity : 0
			}).stop().animate({
				opacity : 1
			}, 500);
			this._$tabs.filter(".now").removeClass().end().eq(i)
					.addClass("now");
			this._$titleC.html(this._curData.t);
			if (this._$desc)
				this._$desc.html(this._curData.t1);
			if (this._cfg.afterAlt) {
				this._cfg.afterAlt(this);
			}
			;
		}
	};
	$.fn.focusImg = function(cfg, data) {
		return this.each(function() {
			cfg.$d = $(this);
			new p.M(cfg, data);
		});
	};
	$.fn.focusImg.Register = function(key, fiObj) {
		p.cache[key] = fiObj;
	};
	$.fn.focusImg.Get = function(key) {
		return p.cache[key];
	};
})(jQuery);
$.fn.focusImg.Register("fi01", {
	init : function(fi) {
		var html = '<img class="fi_player"/>';
		html += '<div class="fi_tab ' + fi.place + '"></div>';
		html += '<div class="fi_tt"></div>';
		fi.$d.append(html);
		fi._$tabC = fi.$d.find(".fi_tab");
		fi._$titleC = fi.$d.find(".fi_tt");
		fi._$img = fi.$d.find(".fi_player");
		if (fi.text) {
			fi._$titleC.show();
		} else {
			fi._$titleC.hide();
		}
		;
		html = "";
		for (var i = 0; i < fi.focusData.length; i++) {
			html += '<span>' + (i + 1) + '</span>';
		}
		;
		fi._$tabC.append(html);
		fi._$tabs = fi._$tabC.find("span");
	},
	initEvts : function(fi) {
		fi.$d.click(function() {
			window.open(fi._$img.attr("link"));
		});
	}
});
$.fn.focusImg.Register("fi02", {
	init : function(fi) {
		var html = '<div id="' + fi.id + '_' + fi.type + '" class="fi02_'
				+ fi.type + '">';
		html += '<img class="fi_player"/>';
		html += '<div class="fi_ovl"></div>';
		html += '<div class="fi_tt"></div>';
		html += '<div class="fi_bg"></div>';
		html += '<div class="fi_link"></div>';
		html += '<div class="fi_tab"></div>';
		html += '</div>';
		fi.$d.append(html);
		fi._$tabC = fi.$d.find(".fi_tab");
		fi._$titleC = fi.$d.find(".fi_tt");
		fi._$img = fi.$d.find(".fi_player");
		fi._$transparentOvl = fi.$d.find(".fi_ovl").css("opacity", 0.5);
		html = "";
		for (var i = 0; i < fi.focusData.length; i++) {
			html += "<span>" + (i + 1) + "</span>";
		}
		;
		fi._$tabC.append(html);
		fi._$tabs = fi._$tabC.find("span");
	},
	initEvts : function(fi) {
		fi.$d.click(function() {
			window.open(fi._$img.attr("link"));
		});
	}
});
$.fn.focusImg
		.Register(
				"fi03",
				{
					init : function(fi) {
						var html = '<div class="fi03_' + fi.type + '"' + 'id="'
								+ fi.id + '_' + fi.type + '">';
						html += '<div class="fi_ct">';
						html += '<img class="fi_player"/><div class="fi_ovl"></div><div class="fi_tt"></div><div class="fi_desc"></div>';
						html += '</div>';
						html += '<div class="fi_tab"></div>';
						html += '</div>';
						fi.$d.append(html);
						fi._$transparentOvl = fi.$d.find(".fi_ovl").css(
								"opacity", 0.5);
						fi._$img = fi.$d.find(".fi_player");
						fi._$titleC = fi.$d.find(".fi_tt");
						fi._$desc = fi.$d.find(".fi_desc");
						fi._$tabC = fi.$d.find(".fi_tab");
						html = "";
						for (var i = 0; i < fi.focusData.length; i++) {
							html += "<span>" + (i + 1) + "</span>";
						}
						;
						fi._$tabC.append(html);
						fi._$tabs = fi._$tabC.find("span");
					},
					initEvts : function(fi) {
						fi.$d.find(".fi_ct").click(function() {
							window.open(fi._$img.attr("link"));
						});
					},
					alt : function(fi, i) {
						if (fi.type == 1) {
							fi._$transparentOvl.css({
								left : -600
							}).stop().animate({
								"left" : 0
							}, 200);
						}
						;
						return true;
					}
				});
$.fn.focusImg
		.Register(
				"fi04",
				{
					init : function(fi) {
						var html = '<div class="fi04_' + fi.type + '"' + 'id="'
								+ fi.id + '_' + fi.type + '">';
						html += '<div class="fi_ct">';
						html += '<img class="fi_player"/><div class="fi_ovl"></div><div class="fi_tt"></div><div class="fi_desc"></div>';
						html += '</div>';
						html += '<div class="fi_tab"><span class="fi_pointer"></span><dl></dl></div>';
						html += '</div>';
						fi.$d.append(html);
						fi._$transparentOvl = fi.$d.find(".fi_ovl").css(
								"opacity", 0.5);
						fi._$img = fi.$d.find(".fi_player");
						fi._$titleC = fi.$d.find(".fi_tt");
						fi._$desc = fi.$d.find(".fi_desc");
						fi._$tabC = fi.$d.find("dl");
						fi._$pointer = fi.$d.find(".fi_pointer");
						html = "";
						for (var i = 0; i < fi.focusData.length; i++) {
							fi.focusData[i].p1 = ((!fi.focusData[i].p1) || (fi.focusData[i].p1 == "")) ? fi.focusData[i].p
									: fi.focusData[i].p1;
							html += '<dd><img src="' + fi.focusData[i].p1
									+ '"/></dd>';
						}
						;
						fi._$tabC.append(html).find("img").css("opacity", 0.5);
						fi._$tabs = fi._$tabC.find("dd");
					},
					initEvts : function(fi) {
						fi.$d.find(".fi_ct").click(function() {
							window.open(fi._$img.attr("link"));
						});
						fi._$pointer.click(function() {
							window.open(fi._$img.attr("link"));
						});
					},
					alt : function(fi, i) {
						fi._$tabs.filter(".now").children().css("opacity", .5);
						fi._$tabs.eq(i).children().css("opacity", 1);
						switch (fi.type) {
						case "1":
							fi._$pointer.stop().animate({
								"left" : i * fi.ptStepX + fi.ptStepX_
							}, 200);
							break;
						case "2":
							fi._$pointer.stop().animate({
								"top" : i * fi.ptStepY + fi.ptStepY_
							}, 200);
							break;
						}
						;
						return true;
					}
				});
$.fn.focusImg
		.Register(
				"fi05",
				{
					init : function(fi) {
						var html = '<div class="fi05_' + fi.type + '"' + 'id="'
								+ fi.id + '_' + fi.type + '">';
						html += '<div class="fi_ct">';
						html += '<img class="fi_player"/><div class="fi_ovl"></div><div class="fi_tt"></div>';
						html += '</div>';
						html += '<div class="fi_tab"><dl></dl></div>';
						html += '</div>';
						fi.$d.append(html);
						fi._$transparentOvl = fi.$d.find(".fi_ovl").css(
								"opacity", 0.5);
						fi._$img = fi.$d.find(".fi_player");
						fi._$titleC = fi.$d.find(".fi_tt");
						fi._$tabC = fi.$d.find("dl");
						html = "";
						for (var i = 0; i < fi.focusData.length; i++) {
							fi.focusData[i].p1 = ((!fi.focusData[i].p1) || (fi.focusData[i].p1 == "")) ? fi.focusData[i].p
									: fi.focusData[i].p1;
							html += '<dd><img src="' + fi.focusData[i].p1
									+ '"/><div>' + fi.focusData[i].t
									+ '</div></dd>';
						}
						;
						fi._$tabC.append(html);
						fi._$tabs = fi._$tabC.find("dd");
					},
					initEvts : function(fi) {
						fi._$tabs.mouseenter(function() {
							jQuery(this).addClass("hover");
						});
						fi._$tabs.mouseleave(function() {
							jQuery(this).removeClass("hover");
						});
						fi.$d.find(".fi_ct").click(function() {
							window.open(fi._$img.attr("link"));
						});
					},
					alt : function(fi, i) {
						fi._$transparentOvl.css({
							bottom : -40
						}).stop().animate({
							"bottom" : 0
						}, 200);
						fi._$titleC.css({
							bottom : -24
						}).stop().animate({
							"bottom" : 16
						}, 200);
						return true;
					}
				});
$.fn.focusImg
		.Register(
				"fi06",
				{
					init : function(fi) {
						var html = '<div class="fi06_' + fi.type + ' clear"'
								+ 'id="' + fi.id + '_' + fi.type + '">';
						html += '<div class="fi_ct l">';
						html += '<a target="_blank"><img class="fi_player"/></a><div class="fi_ovl"></div>';
						html += '<div class="fi_note"><div class="fi_tt"></div><div class="fi_desc"></div></div>';
						html += '<span class="fi_btnplay"></span>';
						html += '</div>';
						html += '<div class="fi_tab r">';
						html += '<span class="fi_up"><a href="#" class="fi_btn"></a></span><span class="fi_down"><a href="#" class="fi_btn"></a></span>';
						html += '<div class="fi_tab_"><dl></dl></div>';
						html += '</div>';
						html += '</div>';
						fi.$d.html(html);
						fi._$img = fi.$d.find(".fi_player");
						fi._$tabC = fi.$d.find(".fi_tab dl");
						fi._$titleC = fi.$d.find(".fi_tt");
						fi._$desc = fi.$d.find(".fi_desc");
						fi._$transparentOvl = fi.$d.find(".fi_ovl");
						fi._$note = fi.$d.find(".fi_note");
						fi._$tabOvl = fi.$d.find(".fi_tab_");
						html = "";
						for (var i = 0; i < fi.focusData.length; i++) {
							fi.focusData[i].p1 = ((!fi.focusData[i].p1) || (fi.focusData[i].p1 == "")) ? fi.focusData[i].p
									: fi.focusData[i].p1;
							html += '<dd><img src="'
									+ fi.focusData[i].p1
									+ '"/><div class="fi_tt0"><span class="fi_icon"></span>'
									+ fi.focusData[i].t_
									+ '</div><div class="fi_desc0">'
									+ fi.focusData[i].t1_ + '</div></dd>';
						}
						;
						fi._$tabC.html(html);
						fi._$tabs = fi._$tabC.find("dd");
					},
					initEvts : function(fi, gogo) {
						var _num = fi._$tabC.height() - fi._$tabOvl.height();
						fi.$d.find(".fi_btn").click(function(e) {
							this.blur();
							return false;
						});
						fi.$d
								.find(".r > .fi_up")
								.mousedown(
										function() {
											if (fi._$tabC.position().top < 0) {
												if (!fi._$tabC.is(":animated")) {
													clearInterval(fi.autoPlay);
													clearTimeout(fi.autoPlay1);
													fi._$tabC
															.stop()
															.animate(
																	{
																		top : "+="
																				+ fi.ptStepY
																	},
																	200,
																	function() {
																		fi.autoPlay1 = window
																				.setTimeout(
																						function() {
																							var s = fi._$tabs
																									.filter(
																											".now")
																									.index();
																							s = (s - 1) == -1 ? 0
																									: (s - 1);
																							gogo(s);
																						},
																						fi.speed);
																	});
												}
												;
											}
											;
										});
						fi.$d
								.find(".r > .fi_down")
								.mousedown(
										function() {
											if (fi._$tabC.position().top > -_num) {
												if (!fi._$tabC.is(":animated")) {
													clearInterval(fi.autoPlay);
													clearTimeout(fi.autoPlay1);
													fi._$tabC
															.stop()
															.animate(
																	{
																		top : "-="
																				+ fi.ptStepY
																	},
																	200,
																	function() {
																		fi.autoPlay1 = window
																				.setTimeout(
																						function() {
																							var s = fi._$tabs
																									.filter(
																											".now")
																									.index();
																							s = (s + 1) == fi._$tabs.length ? 0
																									: (s + 1);
																							gogo(s);
																						},
																						fi.speed);
																	});
												}
												;
											}
											;
										});
						fi.$d.find(".fi_ct").hover(function() {
							$(this).find(".fi_btnplay").addClass("now");
						}, function() {
							$(this).find(".fi_btnplay").removeClass("now");
						}).click(function() {
							window.open($(this).find("a:eq(0)").attr("href"));
						});
						fi._$img.parent("a").click(function(e) {
							e.preventDefault();
							return true;
						});
					},
					alt : function(fi, i) {
						fi._$img.attr("src", fi.focusData[i].p).parent().attr(
								"href", fi.focusData[i].l);
						fi._$tabs.removeClass("now").eq(i).addClass("now");
						fi._$titleC.html(fi.focusData[i].t);
						fi._$desc.html(fi.focusData[i].t1);
						var _w = fi._$note.width(), _h = fi._$tabOvl.height();
						fi._$transparentOvl.css("width", 0).stop().animate({
							width : _w
						}, 200);
						var _num1 = fi._$tabs.filter(".now").prevAll().length
								* fi.ptStepY;
						var _num2 = fi._$tabC.height() - _h;
						var _num3 = _num1 - (_h - fi.ptStepY);
						if (!fi._$tabC.is(":animated")) {
							if (fi._$tabC.position().top > -_num3) {
								fi._$tabC.stop().animate({
									top : -_num3
								}, 200);
							}
							;
							if (fi._$tabC.position().top < (-_num1)) {
								fi._$tabC.stop().animate({
									top : -_num1
								}, 200);
							}
						}
						if (fi._$tabs[0].className == "now") {
							if (!fi._$tabC.is(":animated")) {
								fi._$tabC.stop().animate({
									top : 0
								}, 200);
							}
						}
						;
						return false;
					}
				});
$.fn.focusImg
		.Register(
				"fi07",
				{
					init : function(fi) {
						var html = '<div class="fi07_' + fi.type + '" id="'
								+ fi.id + '_' + fi.type + '">';
						html += '<div class="fi_ct">';
						html += '<div class="fi_list"></div><div class="fi_ovl"></div><div class="fi_tt"></div>';
						html += '</div>';
						html += '<div class="fi_tab">';
						html += '<em class="fi_btn l"><a href="#"></a></em><em class="fi_btn r"><a href="#"></a></em>';
						html += '</div>';
						html += '</div>';
						fi.$d.html(html);
						fi._$tabC = fi.$d.find(".fi_tab");
						fi._$titleC = fi.$d.find(".fi_tt");
						fi._$transparentOvl = fi.$d.find(".fi_ovl").css(
								"opacity", .5);
						fi._$list = fi.$d.find(".fi_list");
						fi._$btnL = fi._$tabC.find(".l");
						fi._$btnR = fi._$tabC.find(".r");
						html = "";
						var html1 = "";
						for (var i = 0; i < fi.focusData.length; i++) {
							html += '<span><a href="' + fi.focusData[i].l
									+ '"></a></span>';
							html1 += '<img src="' + fi.focusData[i].p + '"/>';
						}
						;
						fi._$btnL.after(html);
						fi._$list.html(html1);
						fi._$tabs = fi._$tabC.find("span");
						fi.ptStepX = fi.$d.find(".fi_ct").width();
					},
					initEvts : function(fi, gogo) {
						var l = function() {
							return parseInt(fi._$list.css("left"));
						};
						var _this = this;
						fi._$tabC.find("a").click(function(e) {
							this.blur();
							return false;
						});
						fi._$btnL.mousedown(function() {
							var s = fi._$tabs
									.index(fi._$tabs.filter(".now")[0]);
							if (s == 0 || fi._$list.is(":animated"))
								return;
							clearInterval(fi.autoPlay);
							clearTimeout(fi.autoPlay1);
							_this.alt(fi, s - 1, function() {
								fi.autoPlay1 = window.setTimeout(function() {
									gogo(s);
								}, fi.speed);
							});
						});
						fi._$btnR.mousedown(function() {
							var s = fi._$tabs
									.index(fi._$tabs.filter(".now")[0]);
							if ((s == fi._$tabs.length - 1)
									|| fi._$list.is(":animated"))
								return;
							clearInterval(fi.autoPlay);
							clearTimeout(fi.autoPlay1);
							_this.alt(fi, s + 1, function() {
								fi.autoPlay1 = window.setTimeout(function() {
									s = (s + 2) == fi._$tabs.length ? 0
											: (s + 2);
									gogo(s);
								}, fi.speed);
							});
						});
						fi.$d.find(".fi_ct").click(
								function(e) {
									window.open(fi._$tabs.filter(".now").find(
											"a").attr("href"));
								});
					},
					alt : function(fi, i, cbk) {
						fi._$tabs.removeClass("now").eq(i).addClass("now");
						fi._$titleC.html(fi.focusData[i].t);
						fi._$transparentOvl.css("width", 0).stop().animate({
							width : fi.ptStepX
						}, 200);
						fi._$list.stop().animate({
							left : -i * fi.ptStepX
						}, 200, cbk);
						return false;
					}
				});