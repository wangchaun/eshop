//校验登录名：只能输入4-20个以字母开头、可带数字、、“.”和下划线的字串
function isRegisterUserName(s) {
	var patrn = /^[a-zA-Z]{1}([a-zA-Z0-9])(\w){2,20}$/;
	if (!patrn.exec(s)) return false
	return true
}
//去除后面空格
String.prototype.Trim = function () {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

//校验密码：只能输入6-12个字母、数字、下划线 
function isPasswd(s) {
	var patrn = /^(\w){6,12}$/;
	if (!patrn.exec(s)) return false
	return true
}

// 判断输入是否是有效的电子邮件
function isemail(str) {
	var result = str.match(/^.+\@(\[?)[a-zA-Z0-9\-\.]+\.([a-zA-Z]{2,3}|[0-9]{1,3})(\]?)$/);
	if (result == null) return false;
	return true;
}

//判断输入是否包含字母、下划线、数字
function isSafetyRate(str) {
	var SafetyRate = 0;
	var i = /[0-9]+/;
	var letter = /[A-Za-z]/;
	var spec = /[_]/;
	var spec1 = /[,.<>{}~!@#$%^&*]/;

	if (i.test(str) && letter.test(str) && spec.test(str)) {
		SafetyRate = 3;
	} else if ((i.test(str) && letter.test(str)) || (i.test(str) && spec.test(str)) || (letter.test(str) && spec.test(str))) {
		SafetyRate = 2;
	} else if (i.test(str) || letter.test(str) || spec.test(str)) {
		SafetyRate = 1;
	}

	if (spec1.test(str)) {
		SafetyRate = 0;
	}

	return SafetyRate;

}

function dcmAdd(arg1, arg2) {
    var r1, r2, m;
    try { r1 = arg1.toString().split(".")[1].length } catch (e) { r1 = 0 }
    try { r2 = arg2.toString().split(".")[1].length } catch (e) { r2 = 0 }
    m = Math.pow(10, Math.max(r1, r2));
    return (dcmMultiply(arg1, m) + dcmMultiply(arg2, m)) / m;
}

function dcmSubtract(arg1, arg2) {
    return dcmAdd(arg1, -arg2);
}

function dcmMultiply(arg1, arg2) {
    var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
    try { m += s1.split(".")[1].length } catch (e) { }
    try { m += s2.split(".")[1].length } catch (e) { }
    return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m);
}

function dcmDivideDiv(arg1, arg2) {
    return dcmMultiply(arg1, 1 / arg2);
}



Hashtable = function () {
	this.items = new Array();
	this.itemsCount = 0;
	this.add = function (key, value) {
		if (!this.containsKey(key)) {
			this.items[key] = value;
			this.itemsCount++;
		}
	}
	this.get = function (key) {
		if (this.containsKey(key))
			return this.items[key];
		else
			return null;
	}

	this.modify = function (key, value) {
		if (this.containsKey(key)) {
			this.items[key] = value;
		}
	}

	this.keys = function () {
		var keys = new Array();
		for (var i in this.items) {
			if (this.items[i] != null)
				keys.push(i);
		}
		return keys;
	}

	this.values = function () {
		var values = new Array();
		for (var i in this.items) {
			if (this.items[i] != null)
				values.push(this.items[i]);
		}
		return values;
	}
	this.remove = function (key) {
		if (this.containsKey(key)) {
			delete this.items[key];
			this.itemsCount--;
		}
	}
	this.containsKey = function (key) {
		return typeof (this.items[key]) != "undefined";

	}
	this.containsValue = function containsValue(value) {
		for (var item in this.items) {
			if (this.items[item] == value)
				return true;
			break;
		}
		return false;
	}

	this.contains = function (keyOrValue) {
		return this.containsKey(keyOrValue) || this.containsValue(keyOrValue);
	}
	this.clear = function () {
		this.items = new Array();
		itemsCount = 0;
	}
	this.size = function () {
		var size = 0;
		for (var i in this.items) {
			if (this.items[i] != null)
				size++;
		}
		return size;
	}
	this.isEmpty = function () {
		return this.size() == 0;
	}

	this.toString = function () {
		var result = '';
		for (var i in this.items) {
			if (this.items[i] != null)
				result += '{' + i + '},{' + this.items[i] + '}\n';
		}
		return result;
	}

};
