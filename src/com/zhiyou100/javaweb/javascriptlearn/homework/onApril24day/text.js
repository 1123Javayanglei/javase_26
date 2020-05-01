(function () {/*

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/
    var l;

    function aa(a) {
        var b = 0;
        return function () {
            return b < a.length ? {done: !1, value: a[b++]} : {done: !0}
        }
    }

    var ba = "function" == typeof Object.defineProperties ? Object.defineProperty : function (a, b, c) {
        a !== Array.prototype && a !== Object.prototype && (a[b] = c.value)
    };

    function ca(a) {
        a = ["object" == typeof globalThis && globalThis, a, "object" == typeof window && window, "object" == typeof self && self, "object" == typeof global && global];
        for (var b = 0; b < a.length; ++b) {
            var c = a[b];
            if (c && c.Math === Math) return c
        }
        throw Error("Cannot find global object");
    }

    var da = ca(this);

    function ea(a) {
        var b = "undefined" != typeof Symbol && Symbol.iterator && a[Symbol.iterator];
        return b ? b.call(a) : {next: aa(a)}
    }

    function fa(a) {
        if (!(a instanceof Array)) {
            a = ea(a);
            for (var b, c = []; !(b = a.next()).done;) c.push(b.value);
            a = c
        }
        return a
    }

    var ha = "function" == typeof Object.create ? Object.create : function (a) {
        function b() {
        }

        b.prototype = a;
        return new b
    }, ia;
    if ("function" == typeof Object.setPrototypeOf) ia = Object.setPrototypeOf; else {
        var ja;
        a:{
            var ka = {Ga: !0}, la = {};
            try {
                la.__proto__ = ka;
                ja = la.Ga;
                break a
            } catch (a) {
            }
            ja = !1
        }
        ia = ja ? function (a, b) {
            a.__proto__ = b;
            if (a.__proto__ !== b) throw new TypeError(a + " is not extensible");
            return a
        } : null
    }
    var ma = ia;

    function na(a, b) {
        a.prototype = ha(b.prototype);
        a.prototype.constructor = a;
        if (ma) ma(a, b); else for (var c in b) if ("prototype" != c) if (Object.defineProperties) {
            var d = Object.getOwnPropertyDescriptor(b, c);
            d && Object.defineProperty(a, c, d)
        } else a[c] = b[c]
    }

    function oa(a, b) {
        if (b) {
            var c = da;
            a = a.split(".");
            for (var d = 0; d < a.length - 1; d++) {
                var e = a[d];
                e in c || (c[e] = {});
                c = c[e]
            }
            a = a[a.length - 1];
            d = c[a];
            b = b(d);
            b != d && null != b && ba(c, a, {configurable: !0, writable: !0, value: b})
        }
    }

    function pa(a, b, c) {
        if (null == a) throw new TypeError("The 'this' value for String.prototype." + c + " must not be null or undefined");
        if (b instanceof RegExp) throw new TypeError("First argument to String.prototype." + c + " must not be a regular expression");
        return a + ""
    }

    oa("String.prototype.endsWith", function (a) {
        return a ? a : function (b, c) {
            var d = pa(this, b, "endsWith");
            void 0 === c && (c = d.length);
            c = Math.max(0, Math.min(c | 0, d.length));
            for (var e = b.length; 0 < e && 0 < c;) if (d[--c] != b[--e]) return !1;
            return 0 >= e
        }
    });
    oa("Array.prototype.find", function (a) {
        return a ? a : function (b, c) {
            a:{
                var d = this;
                d instanceof String && (d = String(d));
                for (var e = d.length, f = 0; f < e; f++) {
                    var g = d[f];
                    if (b.call(c, g, f, d)) {
                        b = g;
                        break a
                    }
                }
                b = void 0
            }
            return b
        }
    });
    var qa = "function" == typeof Object.assign ? Object.assign : function (a, b) {
        for (var c = 1; c < arguments.length; c++) {
            var d = arguments[c];
            if (d) for (var e in d) Object.prototype.hasOwnProperty.call(d, e) && (a[e] = d[e])
        }
        return a
    };
    oa("Object.assign", function (a) {
        return a || qa
    });
    oa("Promise", function (a) {
        function b(g) {
            this.b = 0;
            this.g = void 0;
            this.a = [];
            var h = this.c();
            try {
                g(h.resolve, h.reject)
            } catch (k) {
                h.reject(k)
            }
        }

        function c() {
            this.a = null
        }

        function d(g) {
            return g instanceof b ? g : new b(function (h) {
                h(g)
            })
        }

        if (a) return a;
        c.prototype.b = function (g) {
            if (null == this.a) {
                this.a = [];
                var h = this;
                this.c(function () {
                    h.g()
                })
            }
            this.a.push(g)
        };
        var e = da.setTimeout;
        c.prototype.c = function (g) {
            e(g, 0)
        };
        c.prototype.g = function () {
            for (; this.a && this.a.length;) {
                var g = this.a;
                this.a = [];
                for (var h = 0; h < g.length; ++h) {
                    var k =
                        g[h];
                    g[h] = null;
                    try {
                        k()
                    } catch (m) {
                        this.f(m)
                    }
                }
            }
            this.a = null
        };
        c.prototype.f = function (g) {
            this.c(function () {
                throw g;
            })
        };
        b.prototype.c = function () {
            function g(m) {
                return function (n) {
                    k || (k = !0, m.call(h, n))
                }
            }

            var h = this, k = !1;
            return {resolve: g(this.K), reject: g(this.f)}
        };
        b.prototype.K = function (g) {
            if (g === this) this.f(new TypeError("A Promise cannot resolve to itself")); else if (g instanceof b) this.L(g); else {
                a:switch (typeof g) {
                    case "object":
                        var h = null != g;
                        break a;
                    case "function":
                        h = !0;
                        break a;
                    default:
                        h = !1
                }
                h ? this.I(g) : this.j(g)
            }
        };
        b.prototype.I = function (g) {
            var h = void 0;
            try {
                h = g.then
            } catch (k) {
                this.f(k);
                return
            }
            "function" == typeof h ? this.P(h, g) : this.j(g)
        };
        b.prototype.f = function (g) {
            this.o(2, g)
        };
        b.prototype.j = function (g) {
            this.o(1, g)
        };
        b.prototype.o = function (g, h) {
            if (0 != this.b) throw Error("Cannot settle(" + g + ", " + h + "): Promise already settled in state" + this.b);
            this.b = g;
            this.g = h;
            this.u()
        };
        b.prototype.u = function () {
            if (null != this.a) {
                for (var g = 0; g < this.a.length; ++g) f.b(this.a[g]);
                this.a = null
            }
        };
        var f = new c;
        b.prototype.L = function (g) {
            var h = this.c();
            g.ca(h.resolve, h.reject)
        };
        b.prototype.P = function (g, h) {
            var k = this.c();
            try {
                g.call(h, k.resolve, k.reject)
            } catch (m) {
                k.reject(m)
            }
        };
        b.prototype.then = function (g, h) {
            function k(w, u) {
                return "function" == typeof w ? function (D) {
                    try {
                        m(w(D))
                    } catch (v) {
                        n(v)
                    }
                } : u
            }

            var m, n, r = new b(function (w, u) {
                m = w;
                n = u
            });
            this.ca(k(g, m), k(h, n));
            return r
        };
        b.prototype.catch = function (g) {
            return this.then(void 0, g)
        };
        b.prototype.ca = function (g, h) {
            function k() {
                switch (m.b) {
                    case 1:
                        g(m.g);
                        break;
                    case 2:
                        h(m.g);
                        break;
                    default:
                        throw Error("Unexpected state: " +
                            m.b);
                }
            }

            var m = this;
            null == this.a ? f.b(k) : this.a.push(k)
        };
        b.resolve = d;
        b.reject = function (g) {
            return new b(function (h, k) {
                k(g)
            })
        };
        b.race = function (g) {
            return new b(function (h, k) {
                for (var m = ea(g), n = m.next(); !n.done; n = m.next()) d(n.value).ca(h, k)
            })
        };
        b.all = function (g) {
            var h = ea(g), k = h.next();
            return k.done ? d([]) : new b(function (m, n) {
                function r(D) {
                    return function (v) {
                        w[D] = v;
                        u--;
                        0 == u && m(w)
                    }
                }

                var w = [], u = 0;
                do w.push(void 0), u++, d(k.value).ca(r(w.length - 1), n), k = h.next(); while (!k.done)
            })
        };
        return b
    });
    oa("String.prototype.includes", function (a) {
        return a ? a : function (b, c) {
            return -1 !== pa(this, b, "includes").indexOf(b, c || 0)
        }
    });
    var p = this || self;

    function ra() {
        if (null === sa) a:{
            var a = p.document;
            if ((a = a.querySelector && a.querySelector("script[nonce]")) && (a = a.nonce || a.getAttribute("nonce")) && ta.test(a)) {
                sa = a;
                break a
            }
            sa = ""
        }
        return sa
    }

    var ta = /^[\w+/_-]+[=]{0,2}$/, sa = null;

    function ua(a) {
        a = a.split(".");
        for (var b = p, c = 0; c < a.length; c++) if (b = b[a[c]], null == b) return null;
        return b
    }

    function va() {
    }

    function wa(a) {
        a.la = void 0;
        a.h = function () {
            return a.la ? a.la : a.la = new a
        }
    }

    function xa(a) {
        var b = typeof a;
        if ("object" == b) if (a) {
            if (a instanceof Array) return "array";
            if (a instanceof Object) return b;
            var c = Object.prototype.toString.call(a);
            if ("[object Window]" == c) return "object";
            if ("[object Array]" == c || "number" == typeof a.length && "undefined" != typeof a.splice && "undefined" != typeof a.propertyIsEnumerable && !a.propertyIsEnumerable("splice")) return "array";
            if ("[object Function]" == c || "undefined" != typeof a.call && "undefined" != typeof a.propertyIsEnumerable && !a.propertyIsEnumerable("call")) return "function"
        } else return "null";
        else if ("function" == b && "undefined" == typeof a.call) return "object";
        return b
    }

    function ya(a) {
        var b = typeof a;
        return "object" == b && null != a || "function" == b
    }

    function za(a) {
        return Object.prototype.hasOwnProperty.call(a, Aa) && a[Aa] || (a[Aa] = ++Ba)
    }

    var Aa = "closure_uid_" + (1E9 * Math.random() >>> 0), Ba = 0;

    function Ca(a, b, c) {
        return a.call.apply(a.bind, arguments)
    }

    function Da(a, b, c) {
        if (!a) throw Error();
        if (2 < arguments.length) {
            var d = Array.prototype.slice.call(arguments, 2);
            return function () {
                var e = Array.prototype.slice.call(arguments);
                Array.prototype.unshift.apply(e, d);
                return a.apply(b, e)
            }
        }
        return function () {
            return a.apply(b, arguments)
        }
    }

    function Ea(a, b, c) {
        Function.prototype.bind && -1 != Function.prototype.bind.toString().indexOf("native code") ? Ea = Ca : Ea = Da;
        return Ea.apply(null, arguments)
    }

    function Fa(a, b) {
        var c = Array.prototype.slice.call(arguments, 1);
        return function () {
            var d = c.slice();
            d.push.apply(d, arguments);
            return a.apply(this, d)
        }
    }

    function q(a, b) {
        function c() {
        }

        c.prototype = b.prototype;
        a.prototype = new c;
        a.prototype.constructor = a
    };var Ga = (new Date).getTime();

    function Ha(a, b) {
        for (var c = a.length, d = "string" === typeof a ? a.split("") : a, e = 0; e < c; e++) e in d && b.call(void 0, d[e], e, a)
    }

    function Ia(a, b) {
        for (var c = a.length, d = [], e = 0, f = "string" === typeof a ? a.split("") : a, g = 0; g < c; g++) if (g in f) {
            var h = f[g];
            b.call(void 0, h, g, a) && (d[e++] = h)
        }
        return d
    }

    function Ja(a, b) {
        for (var c = a.length, d = Array(c), e = "string" === typeof a ? a.split("") : a, f = 0; f < c; f++) f in e && (d[f] = b.call(void 0, e[f], f, a));
        return d
    }

    function La(a, b) {
        for (var c = a.length, d = "string" === typeof a ? a.split("") : a, e = 0; e < c; e++) if (e in d && b.call(void 0, d[e], e, a)) return !0;
        return !1
    }

    function Ma(a, b) {
        a:{
            for (var c = a.length, d = "string" === typeof a ? a.split("") : a, e = 0; e < c; e++) if (e in d && b.call(void 0, d[e], e, a)) {
                b = e;
                break a
            }
            b = -1
        }
        return 0 > b ? null : "string" === typeof a ? a.charAt(b) : a[b]
    }

    function Na(a, b) {
        a:{
            for (var c = "string" === typeof a ? a.split("") : a, d = a.length - 1; 0 <= d; d--) if (d in c && b.call(void 0, c[d], d, a)) {
                b = d;
                break a
            }
            b = -1
        }
        return 0 > b ? null : "string" === typeof a ? a.charAt(b) : a[b]
    }

    function Oa(a, b) {
        a:if ("string" === typeof a) a = "string" !== typeof b || 1 != b.length ? -1 : a.indexOf(b, 0); else {
            for (var c = 0; c < a.length; c++) if (c in a && a[c] === b) {
                a = c;
                break a
            }
            a = -1
        }
        return 0 <= a
    };

    function Pa(a) {
        return function () {
            return !a.apply(this, arguments)
        }
    }

    function Qa(a) {
        var b = !1, c;
        return function () {
            b || (c = a(), b = !0);
            return c
        }
    }

    function Ra(a) {
        var b = a;
        return function () {
            if (b) {
                var c = b;
                b = null;
                c()
            }
        }
    };

    function Sa(a, b) {
        var c = {}, d;
        for (d in a) b.call(void 0, a[d], d, a) && (c[d] = a[d]);
        return c
    }

    function Ta(a, b) {
        for (var c in a) if (b.call(void 0, a[c], c, a)) return !0;
        return !1
    }

    function Ua(a, b) {
        return null !== a && b in a
    }

    function Va(a, b) {
        for (var c in a) if (b.call(void 0, a[c], c, a)) return c
    };

    function Wa(a, b) {
        this.c = a === Xa && b || "";
        this.f = Ya
    }

    Wa.prototype.b = !0;
    Wa.prototype.a = function () {
        return this.c.toString()
    };

    function Za(a) {
        if (a instanceof Wa && a.constructor === Wa && a.f === Ya) return a.c;
        xa(a);
        return "type_error:TrustedResourceUrl"
    }

    var Ya = {}, Xa = {};

    function $a(a) {
        return /^[\s\xa0]*([\s\S]*?)[\s\xa0]*$/.exec(a)[1]
    }

    var ab = /&/g, bb = /</g, cb = />/g, db = /"/g, eb = /'/g, fb = /\x00/g;

    function gb(a, b) {
        return -1 != a.indexOf(b)
    }

    function hb(a, b) {
        var c = 0;
        a = $a(String(a)).split(".");
        b = $a(String(b)).split(".");
        for (var d = Math.max(a.length, b.length), e = 0; 0 == c && e < d; e++) {
            var f = a[e] || "", g = b[e] || "";
            do {
                f = /(\d*)(\D*)(.*)/.exec(f) || ["", "", "", ""];
                g = /(\d*)(\D*)(.*)/.exec(g) || ["", "", "", ""];
                if (0 == f[0].length && 0 == g[0].length) break;
                c = ib(0 == f[1].length ? 0 : parseInt(f[1], 10), 0 == g[1].length ? 0 : parseInt(g[1], 10)) || ib(0 == f[2].length, 0 == g[2].length) || ib(f[2], g[2]);
                f = f[3];
                g = g[3]
            } while (0 == c)
        }
        return c
    }

    function ib(a, b) {
        return a < b ? -1 : a > b ? 1 : 0
    };

    function jb(a, b) {
        this.c = a === kb && b || "";
        this.f = lb
    }

    jb.prototype.b = !0;
    jb.prototype.a = function () {
        return this.c.toString()
    };

    function mb(a) {
        if (a instanceof jb && a.constructor === jb && a.f === lb) return a.c;
        xa(a);
        return "type_error:SafeUrl"
    }

    var nb = /^(?:(?:https?|mailto|ftp):|[^:/?#]*(?:[/?#]|$))/i, lb = {}, kb = {};
    var ob;
    a:{
        var pb = p.navigator;
        if (pb) {
            var qb = pb.userAgent;
            if (qb) {
                ob = qb;
                break a
            }
        }
        ob = ""
    }

    function t(a) {
        return gb(ob, a)
    }

    function rb(a) {
        for (var b = /(\w[\w ]+)\/([^\s]+)\s*(?:\((.*?)\))?/g, c = [], d; d = b.exec(a);) c.push([d[1], d[2], d[3] || void 0]);
        return c
    };

    function sb() {
        return (t("Chrome") || t("CriOS")) && !t("Edge")
    }

    function tb() {
        function a(e) {
            e = Ma(e, d);
            return c[e] || ""
        }

        var b = ob;
        if (t("Trident") || t("MSIE")) return ub(b);
        b = rb(b);
        var c = {};
        Ha(b, function (e) {
            c[e[0]] = e[1]
        });
        var d = Fa(Ua, c);
        return t("Opera") ? a(["Version", "Opera"]) : t("Edge") ? a(["Edge"]) : t("Edg/") ? a(["Edg"]) : sb() ? a(["Chrome", "CriOS", "HeadlessChrome"]) : (b = b[2]) && b[1] || ""
    }

    function ub(a) {
        var b = /rv: *([\d\.]*)/.exec(a);
        if (b && b[1]) return b[1];
        b = "";
        var c = /MSIE +([\d\.]+)/.exec(a);
        if (c && c[1]) if (a = /Trident\/(\d.\d)/.exec(a), "7.0" == c[1]) if (a && a[1]) switch (a[1]) {
            case "4.0":
                b = "8.0";
                break;
            case "5.0":
                b = "9.0";
                break;
            case "6.0":
                b = "10.0";
                break;
            case "7.0":
                b = "11.0"
        } else b = "7.0"; else b = c[1];
        return b
    };

    function vb(a, b) {
        a.src = Za(b);
        (b = ra()) && a.setAttribute("nonce", b)
    };var wb = {
        "\x00": "\\0",
        "\b": "\\b",
        "\f": "\\f",
        "\n": "\\n",
        "\r": "\\r",
        "\t": "\\t",
        "\x0B": "\\x0B",
        '"': '\\"',
        "\\": "\\\\",
        "<": "\\u003C"
    }, xb = {"'": "\\'"};

    function yb(a) {
        return String(a).replace(/\-([a-z])/g, function (b, c) {
            return c.toUpperCase()
        })
    };

    function zb() {
        return t("iPhone") && !t("iPod") && !t("iPad")
    };

    function Ab(a) {
        Ab[" "](a);
        return a
    }

    Ab[" "] = va;
    var Bb = zb() || t("iPod"),
        Cb = t("Safari") && !(sb() || t("Coast") || t("Opera") || t("Edge") || t("Edg/") || t("OPR") || t("Firefox") || t("FxiOS") || t("Silk") || t("Android")) && !(zb() || t("iPad") || t("iPod"));
    var Db = {}, Eb = null;

    function x() {
    }

    var Fb = "function" == typeof Uint8Array;

    function y(a, b, c, d) {
        a.a = null;
        b || (b = []);
        a.u = void 0;
        a.f = -1;
        a.b = b;
        a:{
            if (b = a.b.length) {
                --b;
                var e = a.b[b];
                if (!(null === e || "object" != typeof e || Array.isArray(e) || Fb && e instanceof Uint8Array)) {
                    a.g = b - a.f;
                    a.c = e;
                    break a
                }
            }
            a.g = Number.MAX_VALUE
        }
        a.o = {};
        if (c) for (b = 0; b < c.length; b++) e = c[b], e < a.g ? (e += a.f, a.b[e] = a.b[e] || Gb) : (Hb(a), a.c[e] = a.c[e] || Gb);
        if (d && d.length) for (b = 0; b < d.length; b++) Ib(a, d[b])
    }

    var Gb = [];

    function Hb(a) {
        var b = a.g + a.f;
        a.b[b] || (a.c = a.b[b] = {})
    }

    function z(a, b) {
        if (b < a.g) {
            b += a.f;
            var c = a.b[b];
            return c === Gb ? a.b[b] = [] : c
        }
        if (a.c) return c = a.c[b], c === Gb ? a.c[b] = [] : c
    }

    function Jb(a, b) {
        a = z(a, b);
        return null == a ? a : +a
    }

    function Kb(a, b) {
        a = z(a, b);
        return null == a ? a : !!a
    }

    function A(a, b, c) {
        a = z(a, b);
        return null == a ? c : a
    }

    function Lb(a, b) {
        a = Kb(a, b);
        return null == a ? !1 : a
    }

    function Mb(a, b) {
        a = Jb(a, b);
        return null == a ? 0 : a
    }

    function Nb(a, b, c) {
        b < a.g ? a.b[b + a.f] = c : (Hb(a), a.c[b] = c);
        return a
    }

    function Ob(a, b, c) {
        0 !== c ? Nb(a, b, c) : b < a.g ? a.b[b + a.f] = null : (Hb(a), delete a.c[b]);
        return a
    }

    function Ib(a, b) {
        for (var c, d, e = 0; e < b.length; e++) {
            var f = b[e], g = z(a, f);
            null != g && (c = f, d = g, Nb(a, f, void 0))
        }
        return c ? (Nb(a, c, d), c) : 0
    }

    function B(a, b, c) {
        a.a || (a.a = {});
        if (!a.a[c]) {
            var d = z(a, c);
            d && (a.a[c] = new b(d))
        }
        return a.a[c]
    }

    function C(a, b, c) {
        Pb(a, b, c);
        b = a.a[c];
        b == Gb && (b = a.a[c] = []);
        return b
    }

    function Pb(a, b, c) {
        a.a || (a.a = {});
        if (!a.a[c]) {
            for (var d = z(a, c), e = [], f = 0; f < d.length; f++) e[f] = new b(d[f]);
            a.a[c] = e
        }
    }

    function Qb(a) {
        if (a.a) for (var b in a.a) {
            var c = a.a[b];
            if ("array" == xa(c)) for (var d = 0; d < c.length; d++) c[d] && Qb(c[d]); else c && Qb(c)
        }
        return a.b
    }

    x.prototype.j = Fb ? function () {
        var a = Uint8Array.prototype.toJSON;
        Uint8Array.prototype.toJSON = function () {
            var b;
            void 0 === b && (b = 0);
            if (!Eb) {
                Eb = {};
                for (var c = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".split(""), d = ["+/=", "+/", "-_=", "-_.", "-_"], e = 0; 5 > e; e++) {
                    var f = c.concat(d[e].split(""));
                    Db[e] = f;
                    for (var g = 0; g < f.length; g++) {
                        var h = f[g];
                        void 0 === Eb[h] && (Eb[h] = g)
                    }
                }
            }
            b = Db[b];
            c = [];
            for (d = 0; d < this.length; d += 3) {
                var k = this[d], m = (e = d + 1 < this.length) ? this[d + 1] : 0;
                h = (f = d + 2 < this.length) ? this[d + 2] : 0;
                g = k >>
                    2;
                k = (k & 3) << 4 | m >> 4;
                m = (m & 15) << 2 | h >> 6;
                h &= 63;
                f || (h = 64, e || (m = 64));
                c.push(b[g], b[k], b[m] || "", b[h] || "")
            }
            return c.join("")
        };
        try {
            return JSON.stringify(this.b && Qb(this), Rb)
        } finally {
            Uint8Array.prototype.toJSON = a
        }
    } : function () {
        return JSON.stringify(this.b && Qb(this), Rb)
    };

    function Rb(a, b) {
        return "number" !== typeof b || !isNaN(b) && Infinity !== b && -Infinity !== b ? b : String(b)
    }

    function Sb(a, b) {
        return new a(b ? JSON.parse(b) : null)
    };

    function Tb(a) {
        y(this, a, Ub, null)
    }

    q(Tb, x);

    function Vb(a) {
        y(this, a, null, null)
    }

    q(Vb, x);
    var Ub = [2, 3];

    function Wb(a) {
        y(this, a, null, null)
    }

    q(Wb, x);

    function Xb(a) {
        var b = new Wb;
        return Nb(b, 1, a)
    }

    function Yb(a, b) {
        return Nb(a, 2, b)
    }

    function Zb(a, b) {
        return Nb(a, 3, b)
    }

    function $b(a, b) {
        return Nb(a, 4, b)
    };var ac = document, E = window;
    var bc = {"120x90": !0, "160x90": !0, "180x90": !0, "200x90": !0, "468x15": !0, "728x15": !0};

    function cc(a, b) {
        if (15 == b) {
            if (728 <= a) return 728;
            if (468 <= a) return 468
        } else if (90 == b) {
            if (200 <= a) return 200;
            if (180 <= a) return 180;
            if (160 <= a) return 160;
            if (120 <= a) return 120
        }
        return null
    };

    function dc() {
        this.a = E.document || {cookie: ""}
    }

    dc.prototype.set = function (a, b, c) {
        var d = !1;
        if ("object" === typeof c) {
            var e = c.fb;
            d = c.Wa || !1;
            var f = c.domain || void 0;
            var g = c.path || void 0;
            var h = c.Oa
        }
        if (/[;=\s]/.test(a)) throw Error('Invalid cookie name "' + a + '"');
        if (/[;\r\n]/.test(b)) throw Error('Invalid cookie value "' + b + '"');
        void 0 === h && (h = -1);
        this.a.cookie = a + "=" + b + (f ? ";domain=" + f : "") + (g ? ";path=" + g : "") + (0 > h ? "" : 0 == h ? ";expires=" + (new Date(1970, 1, 1)).toUTCString() : ";expires=" + (new Date(+new Date + 1E3 * h)).toUTCString()) + (d ? ";secure" : "") + (null != e ? ";samesite=" +
            e : "")
    };
    dc.prototype.get = function (a, b) {
        for (var c = a + "=", d = (this.a.cookie || "").split(";"), e = 0, f; e < d.length; e++) {
            f = $a(d[e]);
            if (0 == f.lastIndexOf(c, 0)) return f.substr(c.length);
            if (f == a) return ""
        }
        return b
    };

    function ec(a, b, c) {
        a.addEventListener && a.addEventListener(b, c, !1)
    };

    function fc(a, b) {
        b = String(b);
        "application/xhtml+xml" === a.contentType && (b = b.toLowerCase());
        return a.createElement(b)
    }

    function gc(a) {
        this.a = a || p.document || document
    }

    gc.prototype.contains = function (a, b) {
        if (!a || !b) return !1;
        if (a.contains && 1 == b.nodeType) return a == b || a.contains(b);
        if ("undefined" != typeof a.compareDocumentPosition) return a == b || !!(a.compareDocumentPosition(b) & 16);
        for (; b && a != b;) b = b.parentNode;
        return b == a
    };

    function hc(a) {
        ic();
        return new Wa(Xa, a)
    }

    var ic = va;

    function jc() {
        return !kc() && (t("iPod") || t("iPhone") || t("Android") || t("IEMobile"))
    }

    function kc() {
        return t("iPad") || t("Android") && !t("Mobile") || t("Silk")
    };

    function lc(a) {
        try {
            var b;
            if (b = !!a && null != a.location.href) a:{
                try {
                    Ab(a.foo);
                    b = !0;
                    break a
                } catch (c) {
                }
                b = !1
            }
            return b
        } catch (c) {
            return !1
        }
    }

    function mc(a) {
        for (var b = p, c = 0; b && 40 > c++ && (!lc(b) || !a(b));) a:{
            try {
                var d = b.parent;
                if (d && d != b) {
                    b = d;
                    break a
                }
            } catch (e) {
            }
            b = null
        }
    }

    function nc() {
        var a = p;
        mc(function (b) {
            a = b;
            return !1
        });
        return a
    }

    function oc(a, b) {
        var c = a.createElement("script");
        vb(c, hc(b));
        return (a = a.getElementsByTagName("script")[0]) && a.parentNode ? (a.parentNode.insertBefore(c, a), c) : null
    }

    function pc(a, b) {
        return b.getComputedStyle ? b.getComputedStyle(a, null) : a.currentStyle
    }

    function qc(a, b, c) {
        var d = !1;
        void 0 === c || c || (d = rc());
        return !d && !sc() && (c = Math.random(), c < b) ? (c = tc(p), a[Math.floor(c * a.length)]) : null
    }

    function tc(a) {
        if (!a.crypto) return Math.random();
        try {
            var b = new Uint32Array(1);
            a.crypto.getRandomValues(b);
            return b[0] / 65536 / 65536
        } catch (c) {
            return Math.random()
        }
    }

    function F(a, b) {
        if (a) for (var c in a) Object.prototype.hasOwnProperty.call(a, c) && b.call(void 0, a[c], c, a)
    }

    function uc(a) {
        return Va(a, function (b, c) {
            return Object.prototype.hasOwnProperty.call(a, c) && !0
        })
    }

    function vc(a) {
        var b = a.length;
        if (0 == b) return 0;
        for (var c = 305419896, d = 0; d < b; d++) c ^= (c << 5) + (c >> 2) + a.charCodeAt(d) & 4294967295;
        return 0 < c ? c : 4294967296 + c
    }

    var sc = Qa(function () {
        return La(["Google Web Preview", "Mediapartners-Google", "Google-Read-Aloud", "Google-Adwords"], wc) || 1E-4 > Math.random()
    });

    function xc(a, b) {
        var c = -1;
        try {
            a.localStorage && (c = parseInt(a.localStorage.getItem(b), 10))
        } catch (d) {
            return null
        }
        return 0 <= c && 1E3 > c ? c : null
    }

    function yc(a) {
        return sc() ? null : Math.floor(1E3 * tc(a))
    }

    function zc(a, b, c) {
        try {
            if (a.localStorage) return a.localStorage.setItem(b, c), c
        } catch (d) {
        }
        return null
    }

    function Ac(a, b) {
        var c = yc(a);
        return c && zc(a, b, String(c)) ? c : null
    }

    var rc = Qa(function () {
        return wc("MSIE")
    });

    function wc(a) {
        return gb(ob, a)
    }

    var Bc = /^([0-9.]+)px$/, Cc = /^(-?[0-9.]{1,30})$/;

    function Dc(a) {
        return Cc.test(a) && (a = Number(a), !isNaN(a)) ? a : null
    }

    function Ec(a, b) {
        return b ? !/^false$/.test(a) : /^true$/.test(a)
    }

    function G(a) {
        return (a = Bc.exec(a)) ? +a[1] : null
    }

    function Fc(a) {
        a = a && a.toString && a.toString();
        return "string" === typeof a && gb(a, "[native code]")
    }

    var Gc = Qa(function () {
        return jc() ? 2 : kc() ? 1 : 0
    });

    function Hc(a) {
        var b = {display: "none"};
        a.style.setProperty ? F(b, function (c, d) {
            a.style.setProperty(d, c, "important")
        }) : a.style.cssText = Ic(Jc(Kc(a.style.cssText), Lc(b, function (c) {
            return c + " !important"
        })))
    }

    var Jc = Object.assign || function (a, b) {
        for (var c = 1; c < arguments.length; c++) {
            var d = arguments[c];
            if (d) for (var e in d) Object.prototype.hasOwnProperty.call(d, e) && (a[e] = d[e])
        }
        return a
    };

    function Lc(a, b) {
        var c = {}, d;
        for (d in a) Object.prototype.hasOwnProperty.call(a, d) && (c[d] = b.call(void 0, a[d], d, a));
        return c
    }

    function Ic(a) {
        var b = [];
        F(a, function (c, d) {
            null != c && "" !== c && b.push(d + ":" + c)
        });
        return b.length ? b.join(";") + ";" : ""
    }

    function Kc(a) {
        var b = {};
        if (a) {
            var c = /\s*:\s*/;
            Ha((a || "").split(/\s*;\s*/), function (d) {
                if (d) {
                    var e = d.split(c);
                    d = e[0];
                    e = e[1];
                    d && e && (b[d.toLowerCase()] = e)
                }
            })
        }
        return b
    }

    function Mc(a) {
        "complete" === ac.readyState || "interactive" === ac.readyState ? a() : ac.addEventListener("DOMContentLoaded", a)
    }

    function Nc(a, b) {
        var c = "https://pagead2.googlesyndication.com/pagead/gen_204?id=" + b;
        F(a, function (d, e) {
            d && (c += "&" + e + "=" + encodeURIComponent(d))
        });
        window.fetch(c, {keepalive: !0, credentials: "include", redirect: "follow", method: "get", mode: "no-cors"})
    };

    function Oc(a) {
        a = parseFloat(a);
        return isNaN(a) ? 0 : a
    }

    function Pc(a, b) {
        a = parseInt(a, 10);
        return isNaN(a) ? b : a
    }

    var Qc = /^([\w-]+\.)*([\w-]{2,})(:[0-9]+)?$/;

    function Rc(a, b) {
        return a ? (a = a.match(Qc)) ? a[0] : b : b
    };

    function Sc() {
        return "r20200428"
    }

    var Tc = Ec("false", !1), Uc = Ec("false", !1), Vc = Ec("false", !1), Wc = Ec("true", !1) || !Uc;

    function Xc() {
        return Rc("", "pagead2.googlesyndication.com")
    };

    function Yc() {
    };/*
 Copyright (c) Microsoft Corporation. All rights reserved.
 Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 this file except in compliance with the License. You may obtain a copy of the
 License at http://www.apache.org/licenses/LICENSE-2.0

 THIS CODE IS PROVIDED ON AN *AS IS* BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, EITHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION ANY IMPLIED
 WARRANTIES OR CONDITIONS OF TITLE, FITNESS FOR A PARTICULAR PURPOSE,
 MERCHANTABLITY OR NON-INFRINGEMENT.

 See the Apache Version 2.0 License for specific language governing permissions
 and limitations under the License.
*/
    function Zc(a) {
        y(this, a, $c, ad)
    }

    q(Zc, x);
    var $c = [2, 8], ad = [[3, 4, 5], [6, 7]];

    function bd(a) {
        return null != a ? !a : a
    }

    function cd(a, b) {
        for (var c = !1, d = 0; d < a.length; d++) {
            var e = a[d].call();
            if (e == b) return e;
            null == e && (c = !0)
        }
        if (!c) return !b
    }

    function dd(a, b) {
        var c = C(a, Zc, 2);
        if (!c.length) return ed(a, b);
        a = A(a, 1, 0);
        if (1 == a) return bd(dd(c[0], b));
        c = Ja(c, function (d) {
            return function () {
                return dd(d, b)
            }
        });
        switch (a) {
            case 2:
                return cd(c, !1);
            case 3:
                return cd(c, !0)
        }
    }

    function ed(a, b) {
        var c = Ib(a, ad[0]);
        a:{
            switch (c) {
                case 3:
                    var d = A(a, 3, 0);
                    break a;
                case 4:
                    d = A(a, 4, 0);
                    break a;
                case 5:
                    d = A(a, 5, 0);
                    break a
            }
            d = void 0
        }
        if (d && (b = (b = b[c]) && b[d])) {
            try {
                var e = b.apply(null, z(a, 8))
            } catch (f) {
                return
            }
            b = A(a, 1, 0);
            if (4 == b) return !!e;
            d = null != e;
            if (5 == b) return d;
            if (12 == b) a = A(a, 7, ""); else a:{
                switch (c) {
                    case 4:
                        a = Mb(a, 6);
                        break a;
                    case 5:
                        a = A(a, 7, "");
                        break a
                }
                a = void 0
            }
            if (null != a) {
                if (6 == b) return e === a;
                if (9 == b) return 0 == hb(e, a);
                if (d) switch (b) {
                    case 7:
                        return e < a;
                    case 8:
                        return e > a;
                    case 12:
                        return (new RegExp(a)).test(e);
                    case 10:
                        return -1 == hb(e, a);
                    case 11:
                        return 1 == hb(e, a)
                }
            }
        }
    }

    function fd(a, b) {
        return !a || !(!b || !dd(a, b))
    };

    function gd(a) {
        y(this, a, hd, null)
    }

    q(gd, x);
    var hd = [4];

    function id(a) {
        y(this, a, jd, kd)
    }

    q(id, x);

    function ld(a) {
        y(this, a, null, null)
    }

    q(ld, x);
    var jd = [5], kd = [[1, 2, 3, 6, 7]];

    function md() {
        var a = {};
        this.a = (a[3] = {}, a[4] = {}, a[5] = {}, a)
    }

    wa(md);
    var nd = Ec("false", !1);

    function od(a, b) {
        switch (b) {
            case 1:
                return A(a, 1, 0);
            case 2:
                return A(a, 2, 0);
            case 3:
                return A(a, 3, 0);
            case 6:
                return A(a, 6, 0);
            default:
                return null
        }
    }

    function pd(a, b) {
        if (!a) return null;
        switch (b) {
            case 1:
                return Lb(a, 1);
            case 7:
                return A(a, 3, "");
            case 2:
                return Mb(a, 2);
            case 3:
                return A(a, 3, "");
            case 6:
                return z(a, 4);
            default:
                return null
        }
    }

    var qd = Qa(function () {
        if (!nd) return {};
        try {
            var a = window.sessionStorage && window.sessionStorage.getItem("GGDFSSK");
            if (a) return JSON.parse(a)
        } catch (b) {
        }
        return {}
    });

    function rd(a, b, c, d) {
        d = void 0 === d ? 0 : d;
        var e = qd();
        if (e[a] && null != e[a][b]) return e[a][b];
        b = sd(d)[a][b];
        if (!b) return c;
        b = new id(b);
        b = td(b);
        a = pd(b, a);
        return null != a ? a : c
    }

    function td(a) {
        var b = md.h().a;
        if (b) {
            var c = Na(C(a, ld, 5), function (d) {
                return fd(B(d, Zc, 1), b)
            });
            if (c) return B(c, gd, 2)
        }
        return B(a, gd, 4)
    }

    function ud() {
        this.a = {};
        this.b = []
    }

    wa(ud);

    function vd(a, b, c) {
        return !!rd(1, a, void 0 === b ? !1 : b, c)
    }

    function wd(a, b, c) {
        b = void 0 === b ? 0 : b;
        a = Number(rd(2, a, b, c));
        return isNaN(a) ? b : a
    }

    function xd(a, b, c) {
        return rd(3, a, void 0 === b ? "" : b, c)
    }

    function yd(a, b, c) {
        b = void 0 === b ? [] : b;
        return rd(6, a, b, c)
    }

    function sd(a) {
        var b = {};
        return ud.h().a[a] || (ud.h().a[a] = (b[1] = {}, b[2] = {}, b[3] = {}, b[6] = {}, b))
    }

    function zd(a, b) {
        var c = sd(b);
        F(a, function (d, e) {
            return F(d, function (f, g) {
                return c[e][g] = f
            })
        })
    }

    function Ad(a, b) {
        var c = sd(b);
        Ha(a, function (d) {
            var e = Ib(d, kd[0]), f = od(d, e);
            f && (c[e][f] = Qb(d))
        })
    }

    function Bd(a, b) {
        var c = sd(b);
        Ha(a, function (d) {
            var e = new id(d), f = Ib(e, kd[0]);
            (e = od(e, f)) && (c[f][e] || (c[f][e] = d))
        })
    }

    function Cd() {
        return Ja(Object.keys(ud.h().a), function (a) {
            return Number(a)
        })
    }

    function Dd(a) {
        Oa(ud.h().b, a) || zd(sd(4), a)
    };

    function H(a) {
        this.methodName = a
    }

    var Ed = new H(1), Fd = new H(15), Gd = new H(2), Hd = new H(3), Id = new H(4), Jd = new H(5), Kd = new H(6),
        Ld = new H(7), Md = new H(8), Nd = new H(9), Od = new H(10), Pd = new H(11), Qd = new H(12), Rd = new H(13),
        Sd = new H(14);

    function I(a, b, c) {
        c.hasOwnProperty(a.methodName) || Object.defineProperty(c, String(a.methodName), {value: b})
    }

    function Td(a, b, c) {
        return b[a.methodName] || c || function () {
        }
    }

    function Ud(a) {
        I(Jd, vd, a);
        I(Kd, wd, a);
        I(Ld, xd, a);
        I(Md, yd, a);
        I(Rd, Bd, a);
        I(Fd, Dd, a)
    }

    function Vd(a) {
        I(Id, function (b) {
            md.h().a = b
        }, a);
        I(Nd, function (b, c) {
            var d = md.h();
            d.a[3][b] || (d.a[3][b] = c)
        }, a);
        I(Od, function (b, c) {
            var d = md.h();
            d.a[4][b] || (d.a[4][b] = c)
        }, a);
        I(Pd, function (b, c) {
            var d = md.h();
            d.a[5][b] || (d.a[5][b] = c)
        }, a);
        I(Sd, function (b) {
            for (var c = md.h(), d = ea([3, 4, 5]), e = d.next(); !e.done; e = d.next()) {
                var f = e.value;
                e = void 0;
                var g = c.a[f];
                f = b[f];
                for (e in f) g[e] = f[e]
            }
        }, a)
    }

    function Wd(a) {
        a.hasOwnProperty("init-done") || Object.defineProperty(a, "init-done", {value: !0})
    };

    function Xd() {
        this.b = function (a, b) {
            return void 0 === b ? !1 : b
        };
        this.a = function () {
        }
    }

    function Yd(a, b, c) {
        a.b = function (d, e) {
            return Td(Jd, b)(d, e, c)
        };
        a.a = function () {
            Td(Fd, b)(c)
        }
    }

    wa(Xd);

    function J(a) {
        var b = void 0 === b ? !1 : b;
        return Xd.h().b(a, b)
    };

    function Zd(a) {
        a = void 0 === a ? p : a;
        var b = a.context || a.AMP_CONTEXT_DATA;
        if (!b) try {
            b = a.parent.context || a.parent.AMP_CONTEXT_DATA
        } catch (c) {
        }
        try {
            if (b && b.pageViewId && b.canonicalUrl) return b
        } catch (c) {
        }
        return null
    }

    function $d(a) {
        return (a = a || Zd()) ? lc(a.master) ? a.master : null : null
    };

    function ae(a, b) {
        p.google_image_requests || (p.google_image_requests = []);
        var c = p.document.createElement("img");
        if (b) {
            var d = function (e) {
                b && b(e);
                c.removeEventListener && c.removeEventListener("load", d, !1);
                c.removeEventListener && c.removeEventListener("error", d, !1)
            };
            ec(c, "load", d);
            ec(c, "error", d)
        }
        c.src = a;
        p.google_image_requests.push(c)
    };

    function be(a, b) {
        if (a) for (var c in a) Object.prototype.hasOwnProperty.call(a, c) && b.call(void 0, a[c], c, a)
    }

    function ce(a) {
        return !(!a || !a.call) && "function" === typeof a
    }

    function de(a) {
        a = $d(Zd(a)) || a;
        a.google_unique_id ? ++a.google_unique_id : a.google_unique_id = 1
    }

    function ee(a) {
        a = a.google_unique_id;
        return "number" === typeof a ? a : 0
    }

    function fe(a) {
        a = $d(Zd(a)) || a;
        a = a.google_unique_id;
        return "number" === typeof a ? a : 0
    }

    var ge = !!window.google_async_iframe_id, he = ge && window.parent || window;

    function ie() {
        if (ge && !lc(he)) {
            var a = "." + ac.domain;
            try {
                for (; 2 < a.split(".").length && !lc(he);) ac.domain = a = a.substr(a.indexOf(".") + 1), he = window.parent
            } catch (b) {
            }
            lc(he) || (he = window)
        }
        return he
    }

    var je = /(^| )adsbygoogle($| )/;

    function ke(a) {
        return Tc && a.google_top_window || a.top
    }

    function le(a) {
        a = ke(a);
        return lc(a) ? a : null
    };

    function K(a) {
        a.google_ad_modifications || (a.google_ad_modifications = {});
        return a.google_ad_modifications
    }

    function me(a, b) {
        a:if (a = K(a).eids || [], a.indexOf) b = a.indexOf(b), b = 0 < b || 0 === b; else {
            for (var c = 0; c < a.length; c++) if (a[c] === b) {
                b = !0;
                break a
            }
            b = !1
        }
        return b
    }

    function ne(a, b) {
        a = K(a);
        a.tag_partners = a.tag_partners || [];
        a.tag_partners.push(b)
    }

    function oe(a) {
        K(E).allow_second_reactive_tag = a
    }

    function pe(a, b, c) {
        for (var d = 0; d < a.length; ++d) if ((a[d].ad_slot || b) == b && (a[d].ad_tag_origin || c) == c) return a[d];
        return null
    };var qe = {},
        re = (qe.google_ad_client = !0, qe.google_ad_host = !0, qe.google_ad_host_channel = !0, qe.google_adtest = !0, qe.google_tag_for_child_directed_treatment = !0, qe.google_tag_for_under_age_of_consent = !0, qe.google_tag_partner = !0, qe.google_restrict_data_processing = !0, qe);

    function se() {
        var a = /[a-zA-Z0-9._~-]/, b = /%[89a-zA-Z]./;
        return p.location.pathname.replace(/(%[a-zA-Z0-9]{2})/g, function (c) {
            if (!c.match(b)) {
                var d = decodeURIComponent(c);
                if (d.match(a)) return d
            }
            return c.toUpperCase()
        })
    }

    function te() {
        for (var a = se(), b = "", c = /[/%?&=]/, d = 0; d < a.length; ++d) {
            var e = a[d];
            b = e.match(c) ? b + e : b + encodeURIComponent(e)
        }
        return b
    };

    function L(a) {
        y(this, a, ue, null)
    }

    q(L, x);
    var ue = [4];
    L.prototype.Y = function () {
        return z(this, 3)
    };

    function N(a) {
        y(this, a, null, null)
    }

    q(N, x);

    function ve(a) {
        y(this, a, null, we)
    }

    q(ve, x);

    function xe(a) {
        y(this, a, null, null)
    }

    q(xe, x);

    function ye(a) {
        y(this, a, null, null)
    }

    q(ye, x);

    function ze(a) {
        y(this, a, null, null)
    }

    q(ze, x);
    var we = [[1, 2, 3]];

    function Ae(a) {
        y(this, a, null, null)
    }

    q(Ae, x);

    function Be(a) {
        y(this, a, null, null)
    }

    q(Be, x);

    function Ce(a) {
        y(this, a, De, null)
    }

    q(Ce, x);
    var De = [6, 7, 9, 10, 11];

    function Ee(a) {
        y(this, a, Fe, null)
    }

    q(Ee, x);

    function Ge(a) {
        y(this, a, null, null)
    }

    q(Ge, x);

    function He(a) {
        y(this, a, Ie, null)
    }

    q(He, x);

    function Je(a) {
        y(this, a, null, null)
    }

    q(Je, x);

    function Ke(a) {
        y(this, a, null, null)
    }

    q(Ke, x);

    function Le(a) {
        y(this, a, null, null)
    }

    q(Le, x);

    function Me(a) {
        y(this, a, null, null)
    }

    q(Me, x);
    var Fe = [1, 2, 5, 7], Ie = [2, 5, 6, 11];

    function Ne(a) {
        var b = te().replace(/(^\/)|(\/$)/g, ""), c = vc(b), d = Oe(b);
        return a.find(function (e) {
            var f = null != z(e, 7) ? z(B(e, Je, 7), 1) : z(e, 1);
            e = null != z(e, 7) ? z(B(e, Je, 7), 2) : 2;
            if ("number" !== typeof f) return !1;
            switch (e) {
                case 1:
                    return f == c;
                case 2:
                    return d[f] || !1
            }
            return !1
        }) || null
    }

    function Oe(a) {
        for (var b = {}; ;) {
            b[vc(a)] = !0;
            if (!a) return b;
            a = a.substring(0, a.lastIndexOf("/"))
        }
    };

    function Pe(a, b) {
        var c = void 0 === c ? {} : c;
        this.error = a;
        this.context = b.context;
        this.msg = b.message || "";
        this.id = b.id || "jserror";
        this.meta = c
    }

    function Qe(a) {
        return !!(a.error && a.meta && a.id)
    };var Re = /^https?:\/\/(\w|-)+\.cdn\.ampproject\.(net|org)(\?|\/|$)/;

    function Se(a, b) {
        this.a = a;
        this.b = b
    }

    function Te(a, b, c) {
        this.url = a;
        this.a = b;
        this.ua = !!c;
        this.depth = null
    };

    function Ue() {
        this.c = "&";
        this.f = !1;
        this.b = {};
        this.g = 0;
        this.a = []
    }

    function Ve(a, b) {
        var c = {};
        c[a] = b;
        return [c]
    }

    function We(a, b, c, d, e) {
        var f = [];
        F(a, function (g, h) {
            (g = Xe(g, b, c, d, e)) && f.push(h + "=" + g)
        });
        return f.join(b)
    }

    function Xe(a, b, c, d, e) {
        if (null == a) return "";
        b = b || "&";
        c = c || ",$";
        "string" == typeof c && (c = c.split(""));
        if (a instanceof Array) {
            if (d = d || 0, d < c.length) {
                for (var f = [], g = 0; g < a.length; g++) f.push(Xe(a[g], b, c, d + 1, e));
                return f.join(c[d])
            }
        } else if ("object" == typeof a) return e = e || 0, 2 > e ? encodeURIComponent(We(a, b, c, d, e + 1)) : "...";
        return encodeURIComponent(String(a))
    }

    function Ye(a, b, c, d) {
        a.a.push(b);
        a.b[b] = Ve(c, d)
    }

    function Ze(a, b, c) {
        b = b + "//pagead2.googlesyndication.com" + c;
        var d = $e(a) - c.length;
        if (0 > d) return "";
        a.a.sort(function (n, r) {
            return n - r
        });
        c = null;
        for (var e = "", f = 0; f < a.a.length; f++) for (var g = a.a[f], h = a.b[g], k = 0; k < h.length; k++) {
            if (!d) {
                c = null == c ? g : c;
                break
            }
            var m = We(h[k], a.c, ",$");
            if (m) {
                m = e + m;
                if (d >= m.length) {
                    d -= m.length;
                    b += m;
                    e = a.c;
                    break
                }
                a.f && (e = d, m[e - 1] == a.c && --e, b += m.substr(0, e), e = a.c, d = 0);
                c = null == c ? g : c
            }
        }
        a = "";
        null != c && (a = e + "trn=" + c);
        return b + a
    }

    function $e(a) {
        var b = 1, c;
        for (c in a.b) b = c.length > b ? c.length : b;
        return 3997 - b - a.c.length - 1
    };

    function af(a, b, c, d, e, f) {
        if ((d ? a.a : Math.random()) < (e || .01)) try {
            if (c instanceof Ue) var g = c; else g = new Ue, F(c, function (k, m) {
                var n = g, r = n.g++;
                k = Ve(m, k);
                n.a.push(r);
                n.b[r] = k
            });
            var h = Ze(g, a.b, "/pagead/gen_204?id=" + b + "&");
            h && ("undefined" === typeof f ? ae(h, null) : ae(h, void 0 === f ? null : f))
        } catch (k) {
        }
    };var bf = null;

    function cf() {
        if (null === bf) {
            bf = "";
            try {
                var a = "";
                try {
                    a = p.top.location.hash
                } catch (c) {
                    a = p.location.hash
                }
                if (a) {
                    var b = a.match(/\bdeid=([\d,]+)/);
                    bf = b ? b[1] : ""
                }
            } catch (c) {
            }
        }
        return bf
    };

    function df() {
        var a = p.performance;
        return a && a.now && a.timing ? Math.floor(a.now() + a.timing.navigationStart) : +new Date
    }

    function ef() {
        var a = void 0 === a ? p : a;
        return (a = a.performance) && a.now ? a.now() : null
    };

    function ff(a, b, c) {
        this.label = a;
        this.type = b;
        this.value = c;
        this.duration = 0;
        this.uniqueId = Math.random();
        this.slotId = void 0
    };var gf = p.performance, hf = !!(gf && gf.mark && gf.measure && gf.clearMarks), jf = Qa(function () {
        var a;
        if (a = hf) a = cf(), a = !!a.indexOf && 0 <= a.indexOf("1337");
        return a
    });

    function kf() {
        var a = lf;
        this.b = [];
        this.c = a || p;
        var b = null;
        a && (a.google_js_reporting_queue = a.google_js_reporting_queue || [], this.b = a.google_js_reporting_queue, b = a.google_measure_js_timing);
        this.a = jf() || (null != b ? b : 1 > Math.random())
    }

    function mf(a) {
        a && gf && jf() && (gf.clearMarks("goog_" + a.label + "_" + a.uniqueId + "_start"), gf.clearMarks("goog_" + a.label + "_" + a.uniqueId + "_end"))
    }

    kf.prototype.start = function (a, b) {
        if (!this.a) return null;
        var c = ef() || df();
        a = new ff(a, b, c);
        b = "goog_" + a.label + "_" + a.uniqueId + "_start";
        gf && jf() && gf.mark(b);
        return a
    };

    function nf() {
        var a = of;
        this.j = pf;
        this.c = !0;
        this.b = null;
        this.g = this.J;
        this.a = void 0 === a ? null : a;
        this.f = !1
    }

    l = nf.prototype;
    l.Ba = function (a) {
        this.g = a
    };
    l.ma = function (a) {
        this.b = a
    };
    l.Ca = function (a) {
        this.c = a
    };
    l.Da = function (a) {
        this.f = a
    };
    l.fa = function (a, b, c) {
        try {
            if (this.a && this.a.a) {
                var d = this.a.start(a.toString(), 3);
                var e = b();
                var f = this.a;
                b = d;
                if (f.a && "number" === typeof b.value) {
                    var g = ef() || df();
                    b.duration = g - b.value;
                    var h = "goog_" + b.label + "_" + b.uniqueId + "_end";
                    gf && jf() && gf.mark(h);
                    !f.a || 2048 < f.b.length || f.b.push(b)
                }
            } else e = b()
        } catch (k) {
            f = this.c;
            try {
                mf(d), f = this.g(a, new Pe(k, {message: qf(k)}), void 0, c)
            } catch (m) {
                this.J(217, m)
            }
            if (!f) throw k;
        }
        return e
    };
    l.xa = function (a, b, c, d) {
        var e = this;
        return function (f) {
            for (var g = [], h = 0; h < arguments.length; ++h) g[h] = arguments[h];
            return e.fa(a, function () {
                return b.apply(c, g)
            }, d)
        }
    };
    l.J = function (a, b, c, d, e) {
        e = e || "jserror";
        try {
            var f = new Ue;
            f.f = !0;
            Ye(f, 1, "context", a);
            Qe(b) || (b = new Pe(b, {message: qf(b)}));
            b.msg && Ye(f, 2, "msg", b.msg.substring(0, 512));
            var g = b.meta || {};
            if (this.b) try {
                this.b(g)
            } catch (M) {
            }
            if (d) try {
                d(g)
            } catch (M) {
            }
            b = [g];
            f.a.push(3);
            f.b[3] = b;
            d = p;
            b = [];
            g = null;
            do {
                var h = d;
                if (lc(h)) {
                    var k = h.location.href;
                    g = h.document && h.document.referrer || null
                } else k = g, g = null;
                b.push(new Te(k || "", h));
                try {
                    d = h.parent
                } catch (M) {
                    d = null
                }
            } while (d && h != d);
            k = 0;
            for (var m = b.length - 1; k <= m; ++k) b[k].depth = m - k;
            h = p;
            if (h.location && h.location.ancestorOrigins && h.location.ancestorOrigins.length == b.length - 1) for (m = 1; m < b.length; ++m) {
                var n = b[m];
                n.url || (n.url = h.location.ancestorOrigins[m - 1] || "", n.ua = !0)
            }
            var r = new Te(p.location.href, p, !1);
            h = null;
            var w = b.length - 1;
            for (n = w; 0 <= n; --n) {
                var u = b[n];
                !h && Re.test(u.url) && (h = u);
                if (u.url && !u.ua) {
                    r = u;
                    break
                }
            }
            u = null;
            var D = b.length && b[w].url;
            0 != r.depth && D && (u = b[w]);
            var v = new Se(r, u);
            v.b && Ye(f, 4, "top", v.b.url || "");
            Ye(f, 5, "url", v.a.url || "");
            af(this.j, e, f, this.f, c)
        } catch (M) {
            try {
                af(this.j,
                    e, {context: "ecmserr", rctx: a, msg: qf(M), url: v && v.a.url}, this.f, c)
            } catch (Ka) {
            }
        }
        return this.c
    };

    function qf(a) {
        var b = a.toString();
        a.name && -1 == b.indexOf(a.name) && (b += ": " + a.name);
        a.message && -1 == b.indexOf(a.message) && (b += ": " + a.message);
        if (a.stack) {
            a = a.stack;
            try {
                -1 == a.indexOf(b) && (a = b + "\n" + a);
                for (var c; a != c;) c = a, a = a.replace(/((https?:\/..*\/)[^\/:]*:\d+(?:.|\n)*)\2/, "$1");
                b = a.replace(/\n */g, "\n")
            } catch (d) {
            }
        }
        return b
    };

    function O(a) {
        a = void 0 === a ? "" : a;
        var b = Error.call(this);
        this.message = b.message;
        "stack" in b && (this.stack = b.stack);
        this.name = "TagError";
        this.message = a ? "adsbygoogle.push() error: " + a : "";
        Error.captureStackTrace ? Error.captureStackTrace(this, O) : this.stack = Error().stack || ""
    }

    na(O, Error);

    function rf() {
        this.b = !1;
        this.a = null;
        this.f = !1;
        this.g = Math.random();
        this.c = this.J
    }

    l = rf.prototype;
    l.ma = function (a) {
        this.a = a
    };
    l.Ca = function (a) {
        this.b = a
    };
    l.Da = function (a) {
        this.f = a
    };
    l.Ba = function (a) {
        this.c = a
    };
    l.J = function (a, b, c, d, e) {
        if ((this.f ? this.g : Math.random()) > (void 0 === c ? .01 : c)) return this.b;
        Qe(b) || (b = new Pe(b, {context: a, id: void 0 === e ? "jserror" : e}));
        if (d || this.a) b.meta = {}, this.a && this.a(b.meta), d && d(b.meta);
        p.google_js_errors = p.google_js_errors || [];
        p.google_js_errors.push(b);
        p.error_rep_loaded || (oc(p.document, p.location.protocol + "//pagead2.googlesyndication.com/pagead/js/err_rep.js"), p.error_rep_loaded = !0);
        return this.b
    };
    l.fa = function (a, b, c) {
        try {
            var d = b()
        } catch (e) {
            if (!this.c(a, e, .01, c, "jserror")) throw e;
        }
        return d
    };
    l.xa = function (a, b, c, d) {
        var e = this;
        return function (f) {
            for (var g = [], h = 0; h < arguments.length; ++h) g[h] = arguments[h];
            return e.fa(a, function () {
                return b.apply(c, g)
            }, d)
        }
    };
    var pf, sf, lf = ie(), of = new kf;

    function tf(a) {
        null != a && (lf.google_measure_js_timing = a);
        lf.google_measure_js_timing || (a = of, a.a = !1, a.b != a.c.google_js_reporting_queue && (jf() && Ha(a.b, mf), a.b.length = 0))
    }

    function uf(a) {
        var b = E.jerExpIds;
        if ("array" == xa(b) && 0 !== b.length) {
            var c = a.eid;
            if (c) {
                b = fa(c.split(",")).concat(fa(b));
                c = {};
                for (var d = 0, e = 0; e < b.length;) {
                    var f = b[e++];
                    var g = f;
                    g = ya(g) ? "o" + za(g) : (typeof g).charAt(0) + g;
                    Object.prototype.hasOwnProperty.call(c, g) || (c[g] = !0, b[d++] = f)
                }
                b.length = d;
                a.eid = b.join(",")
            } else a.eid = b.join(",")
        }
    }

    function vf(a) {
        var b = E.jerUserAgent;
        b && (a.useragent = b)
    }

    pf = new function () {
        var a = void 0 === a ? E : a;
        this.b = "http:" === a.location.protocol ? "http:" : "https:";
        this.a = Math.random()
    };
    "number" !== typeof lf.google_srt && (lf.google_srt = Math.random());
    var wf = pf, xf = lf.google_srt;
    0 <= xf && 1 >= xf && (wf.a = xf);
    sf = new nf;
    sf.ma(function (a) {
        uf(a);
        vf(a)
    });
    sf.Da(!0);
    "complete" == lf.document.readyState ? tf() : of.a && ec(lf, "load", function () {
        tf()
    });

    function yf() {
        var a = [zf, Af];
        sf.ma(function (b) {
            Ha(a, function (c) {
                c(b)
            });
            uf(b);
            vf(b)
        })
    }

    function Bf(a, b, c) {
        return sf.fa(a, b, c)
    }

    function Cf(a, b) {
        return sf.xa(a, b, void 0, void 0)
    }

    function Df(a, b, c) {
        af(pf, a, b, !0, c, void 0)
    }

    function Ef(a, b, c, d) {
        var e;
        Qe(b) ? e = b.msg || qf(b.error) : e = qf(b);
        return 0 == e.indexOf("TagError") ? (c = b instanceof Pe ? b.error : b, c.pbr || (c.pbr = !0, sf.J(a, b, .1, d, "puberror")), !1) : sf.J(a, b, c, d)
    };

    function Ff(a, b) {
        this.ra = a;
        this.ya = b
    }

    function Gf(a) {
        var b = [].slice.call(arguments).filter(Pa(function (e) {
            return null === e
        }));
        if (!b.length) return null;
        var c = [], d = {};
        b.forEach(function (e) {
            c = c.concat(e.ra || []);
            d = Object.assign(d, e.ya)
        });
        return new Ff(c, d)
    }

    function Hf(a) {
        switch (a) {
            case 1:
                return new Ff(null, {google_ad_semantic_area: "mc"});
            case 2:
                return new Ff(null, {google_ad_semantic_area: "h"});
            case 3:
                return new Ff(null, {google_ad_semantic_area: "f"});
            case 4:
                return new Ff(null, {google_ad_semantic_area: "s"});
            default:
                return null
        }
    };var If = new Ff(["google-auto-placed"], {google_tag_origin: "qs"});
    var Jf = {}, Kf = (Jf.google_ad_channel = !0, Jf.google_ad_host = !0, Jf);

    function Lf(a, b) {
        a.location.href && a.location.href.substring && (b.url = a.location.href.substring(0, 200));
        Df("ama", b, .01)
    }

    function Mf(a) {
        var b = {};
        F(Kf, function (c, d) {
            d in a && (b[d] = a[d])
        });
        return b
    };var Nf = Pc("2019", 2012);

    function Of(a, b, c) {
        if ("relative" === a) return b;
        c || (c = Wc ? "https" : "http");
        p.location && "https:" == p.location.protocol && "http" == c && (c = "https");
        return [c, "://", a, b].join("")
    }

    function Pf(a, b, c) {
        a = Of(a, b, c);
        2012 < Nf && (b = (b = a.match(/(__[a-z0-9_]+)\.js(?:\?|$)/)) ? b[1] : "", a = a.replace(new RegExp(String(b + ".js").replace(/([-()\[\]{}+?*.$\^|,:#<!\\])/g, "\\$1").replace(/\x08/g, "\\x08"), "g"), ("_fy" + Nf + b + ".js").replace(/\$/g, "$$$$")));
        J(202) && (a += (0 < a.indexOf("?") ? "&" : "?") + "cache=bust");
        return a
    };var Qf = null;

    function Rf() {
        if (!Tc) return !1;
        if (null != Qf) return Qf;
        Qf = !1;
        try {
            var a = le(p);
            a && -1 != a.location.hash.indexOf("google_logging") && (Qf = !0);
            p.localStorage.getItem("google_logging") && (Qf = !0)
        } catch (b) {
        }
        return Qf
    }

    function Sf(a, b) {
        b = void 0 === b ? [] : b;
        var c = !1;
        p.google_logging_queue || (c = !0, p.google_logging_queue = []);
        p.google_logging_queue.push([a, b]);
        c && Rf() && (a = Pf(Xc(), "/pagead/js/logging_library.js"), oc(p.document, a))
    };

    function Tf(a, b, c) {
        this.a = a;
        this.b = b;
        this.c = c
    }

    function Uf(a, b) {
        return {top: a.b - b, right: a.a + a.c + 1, bottom: a.b + b, left: a.a - 1}
    };

    function Vf(a) {
        this.a = {};
        this.b = {};
        if (a) for (var b = 0; b < a.length; ++b) this.add(a[b])
    }

    Vf.prototype.add = function (a) {
        this.a[a] = !0;
        this.b[a] = a
    };
    Vf.prototype.contains = function (a) {
        return !!this.a[a]
    };

    function Wf(a) {
        y(this, a, null, null)
    }

    q(Wf, x);

    function Xf(a) {
        y(this, a, null, null)
    }

    q(Xf, x);

    function Yf(a) {
        y(this, a, null, null)
    }

    q(Yf, x);

    function Zf(a) {
        y(this, a, $f, null)
    }

    q(Zf, x);
    var $f = [5];

    function ag(a) {
        try {
            var b = a.localStorage.getItem("google_ama_settings");
            return b ? Sb(Zf, b) : null
        } catch (c) {
            return null
        }
    };

    function bg() {
        this.a = {};
        this.b = {}
    }

    bg.prototype.set = function (a, b) {
        this.a[a] = b;
        this.b[a] = a
    };
    bg.prototype.get = function (a, b) {
        return void 0 !== this.a[a] ? this.a[a] : b
    };
    var cg = {rectangle: 1, horizontal: 2, vertical: 4};
    var dg = {overlays: 1, interstitials: 2, vignettes: 2, inserts: 3, immersives: 4, list_view: 5};

    function eg() {
        this.wasPlaTagProcessed = !1;
        this.wasReactiveAdConfigReceived = {};
        this.adCount = {};
        this.wasReactiveAdVisible = {};
        this.stateForType = {};
        this.reactiveTypeEnabledInAsfe = {};
        this.wasReactiveTagRequestSent = !1;
        this.reactiveTypeDisabledByPublisher = {};
        this.tagSpecificState = {};
        this.improveCollisionDetection = 1;
        this.messageValidationEnabled = !1;
        this.floatingAdsStacking = new fg
    }

    function gg(a) {
        a.google_reactive_ads_global_state ? null == a.google_reactive_ads_global_state.floatingAdsStacking && (a.google_reactive_ads_global_state.floatingAdsStacking = new fg) : a.google_reactive_ads_global_state = new eg;
        return a.google_reactive_ads_global_state
    }

    function fg() {
        this.maxZIndexRestrictions = {};
        this.nextRestrictionId = 0;
        this.maxZIndexListeners = []
    };

    function hg(a) {
        a = a.document;
        var b = {};
        a && (b = "CSS1Compat" == a.compatMode ? a.documentElement : a.body);
        return b || {}
    }

    function P(a) {
        return hg(a).clientWidth
    };

    function ig(a, b) {
        for (var c = ["width", "height"], d = 0; d < c.length; d++) {
            var e = "google_ad_" + c[d];
            if (!b.hasOwnProperty(e)) {
                var f = G(a[c[d]]);
                f = null === f ? null : Math.round(f);
                null != f && (b[e] = f)
            }
        }
    }

    function jg(a, b) {
        return !((Cc.test(b.google_ad_width) || Bc.test(a.style.width)) && (Cc.test(b.google_ad_height) || Bc.test(a.style.height)))
    }

    function kg(a, b) {
        return (a = lg(a, b)) ? a.y : 0
    }

    function lg(a, b) {
        try {
            var c = b.document.documentElement.getBoundingClientRect(), d = a.getBoundingClientRect();
            return {x: d.left - c.left, y: d.top - c.top}
        } catch (e) {
            return null
        }
    }

    function mg(a, b) {
        do {
            var c = pc(a, b);
            if (c && "fixed" == c.position) return !1
        } while (a = a.parentElement);
        return !0
    }

    function ng(a) {
        var b = 0, c;
        for (c in cg) -1 != a.indexOf(c) && (b |= cg[c]);
        return b
    }

    function og(a, b, c, d, e) {
        if (ke(a) != a) return le(a) ? 3 : 16;
        if (!(488 > P(a))) return 4;
        if (!(a.innerHeight >= a.innerWidth)) return 5;
        var f = P(a);
        if (!f || (f - c) / f > d) a = 6; else {
            if (c = "true" != e.google_full_width_responsive) a:{
                c = P(a);
                for (b = b.parentElement; b; b = b.parentElement) if ((d = pc(b, a)) && (e = G(d.width)) && !(e >= c) && "visible" != d.overflow) {
                    c = !0;
                    break a
                }
                c = !1
            }
            a = c ? 7 : !0
        }
        return a
    }

    function pg(a, b, c, d) {
        var e = og(b, c, a, .3, d);
        !0 !== e ? a = e : "true" == d.google_full_width_responsive || mg(c, b) ? qg(b) ? a = !0 : (b = P(b), a = b - a, a = b && 0 <= a ? !0 : b ? -10 > a ? 11 : 0 > a ? 14 : 12 : 10) : a = 9;
        return a
    }

    function rg(a, b, c) {
        a = a.style;
        "rtl" == b ? J(251) ? a.setProperty("margin-right", c, "important") : a.marginRight = c : J(251) ? a.setProperty("margin-left", c, "important") : a.marginLeft = c
    }

    function sg(a, b) {
        if (3 == b.nodeType) return /\S/.test(b.data);
        if (1 == b.nodeType) {
            if (/^(script|style)$/i.test(b.nodeName)) return !1;
            try {
                var c = pc(b, a)
            } catch (d) {
            }
            return !c || "none" != c.display && !("absolute" == c.position && ("hidden" == c.visibility || "collapse" == c.visibility))
        }
        return !1
    }

    function tg(a, b) {
        for (var c = 0; 100 > c && b.parentElement; ++c) {
            for (var d = b.parentElement.childNodes, e = 0; e < d.length; ++e) {
                var f = d[e];
                if (f != b && sg(a, f)) return
            }
            b = b.parentElement;
            b.style.width = "100%";
            b.style.height = "auto"
        }
    }

    function ug(a, b, c) {
        a = lg(b, a);
        return "rtl" == c ? -a.x : a.x
    }

    function vg(a, b) {
        var c;
        c = (c = b.parentElement) ? (c = pc(c, a)) ? c.direction : "" : "";
        if (c) {
            b.style.border = b.style.borderStyle = b.style.outline = b.style.outlineStyle = b.style.transition = "none";
            b.style.borderSpacing = b.style.padding = "0";
            rg(b, c, "0px");
            b.style.width = P(a) + "px";
            if (0 !== ug(a, b, c)) {
                rg(b, c, "0px");
                var d = ug(a, b, c);
                rg(b, c, -1 * d + "px");
                a = ug(a, b, c);
                0 !== a && a !== d && rg(b, c, d / (a - d) * d + "px")
            }
            b.style.zIndex = 30
        }
    }

    function qg(a) {
        return J(233) || a.location && "#bffwroe2etoq" == a.location.hash
    };

    function Q(a, b) {
        this.b = a;
        this.a = b
    }

    l = Q.prototype;
    l.minWidth = function () {
        return this.b
    };
    l.height = function () {
        return this.a
    };
    l.R = function (a) {
        return 300 < a && 300 < this.a ? this.b : Math.min(1200, Math.round(a))
    };
    l.ja = function (a) {
        return this.R(a) + "x" + this.height()
    };
    l.ba = function () {
    };

    function R(a, b, c, d) {
        d = void 0 === d ? function (f) {
            return f
        } : d;
        var e;
        return a.style && a.style[c] && d(a.style[c]) || (e = pc(a, b)) && e[c] && d(e[c]) || null
    }

    function wg(a) {
        return function (b) {
            return b.minWidth() <= a
        }
    }

    function xg(a, b, c, d) {
        var e = a && yg(c, b), f = zg(b, d);
        return function (g) {
            return !(e && g.height() >= f)
        }
    }

    function Ag(a) {
        return function (b) {
            return b.height() <= a
        }
    }

    function yg(a, b) {
        return kg(a, b) < hg(b).clientHeight - 100
    }

    function Bg(a, b) {
        a = kg(a, b);
        b = hg(b).clientHeight;
        return 0 == b ? null : a / b
    }

    function Cg(a, b) {
        var c = R(b, a, "height", G);
        if (c) return c;
        var d = b.style.height;
        b.style.height = "inherit";
        c = R(b, a, "height", G);
        b.style.height = d;
        if (c) return c;
        c = Infinity;
        do (d = b.style && G(b.style.height)) && (c = Math.min(c, d)), (d = R(b, a, "maxHeight", G)) && (c = Math.min(c, d)); while ((b = b.parentElement) && "HTML" != b.tagName);
        return c
    }

    function zg(a, b) {
        var c = 0 == ee(a);
        return b && c ? Math.max(250, 2 * hg(a).clientHeight / 3) : 250
    };

    function Dg(a, b) {
        for (var c = [], d = a.length, e = 0; e < d; e++) c.push(a[e]);
        c.forEach(b, void 0)
    };

    function Eg(a) {
        if (1 != a.nodeType) var b = !1; else if (b = "INS" == a.tagName) a:{
            b = ["adsbygoogle-placeholder"];
            a = a.className ? a.className.split(/\s+/) : [];
            for (var c = {}, d = 0; d < a.length; ++d) c[a[d]] = !0;
            for (d = 0; d < b.length; ++d) if (!c[b[d]]) {
                b = !1;
                break a
            }
            b = !0
        }
        return b
    };

    function Fg(a, b, c) {
        switch (c) {
            case 0:
                b.parentNode && b.parentNode.insertBefore(a, b);
                break;
            case 3:
                if (c = b.parentNode) {
                    var d = b.nextSibling;
                    if (d && d.parentNode != c) for (; d && 8 == d.nodeType;) d = d.nextSibling;
                    c.insertBefore(a, d)
                }
                break;
            case 1:
                b.insertBefore(a, b.firstChild);
                break;
            case 2:
                b.appendChild(a)
        }
        Eg(b) && (b.setAttribute("data-init-display", b.style.display), b.style.display = "block")
    };

    function Gg(a, b, c) {
        function d(f) {
            f = Hg(f);
            return null == f ? !1 : c > f
        }

        function e(f) {
            f = Hg(f);
            return null == f ? !1 : c < f
        }

        switch (b) {
            case 0:
                return {
                    G: Ig(a.previousSibling, e), da: function (f) {
                        return Ig(f.previousSibling, e)
                    }, ea: 0
                };
            case 2:
                return {
                    G: Ig(a.lastChild, e), da: function (f) {
                        return Ig(f.previousSibling, e)
                    }, ea: 0
                };
            case 3:
                return {
                    G: Ig(a.nextSibling, d), da: function (f) {
                        return Ig(f.nextSibling, d)
                    }, ea: 3
                };
            case 1:
                return {
                    G: Ig(a.firstChild, d), da: function (f) {
                        return Ig(f.nextSibling, d)
                    }, ea: 3
                }
        }
        throw Error("Un-handled RelativePosition: " +
            b);
    }

    function Hg(a) {
        return a.hasOwnProperty("google-ama-order-assurance") ? a["google-ama-order-assurance"] : null
    }

    function Ig(a, b) {
        return a && b(a) ? a : null
    };

    function Jg(a, b) {
        for (var c = 0; c < b.length; c++) {
            var d = b[c], e = yb(d.cb);
            a[e] = d.value
        }
    };var Kg = null;

    function Lg() {
        if (!Kg) {
            for (var a = p, b = a, c = 0; a && a != a.parent;) if (a = a.parent, c++, lc(a)) b = a; else break;
            Kg = b
        }
        return Kg
    };

    function Mg(a, b, c, d) {
        this.f = a;
        this.b = b;
        this.c = c;
        this.a = d
    }

    function Ng(a, b) {
        var c = [];
        try {
            c = b.querySelectorAll(a.f)
        } catch (g) {
        }
        if (!c.length) return [];
        b = c;
        c = b.length;
        if (0 < c) {
            for (var d = Array(c), e = 0; e < c; e++) d[e] = b[e];
            b = d
        } else b = [];
        b = Og(a, b);
        "number" === typeof a.b && (c = a.b, 0 > c && (c += b.length), b = 0 <= c && c < b.length ? [b[c]] : []);
        if ("number" === typeof a.c) {
            c = [];
            for (d = 0; d < b.length; d++) {
                e = Pg(b[d]);
                var f = a.c;
                0 > f && (f += e.length);
                0 <= f && f < e.length && c.push(e[f])
            }
            b = c
        }
        return b
    }

    Mg.prototype.toString = function () {
        return JSON.stringify({
            nativeQuery: this.f,
            occurrenceIndex: this.b,
            paragraphIndex: this.c,
            ignoreMode: this.a
        })
    };

    function Og(a, b) {
        if (null == a.a) return b;
        switch (a.a) {
            case 1:
                return b.slice(1);
            case 2:
                return b.slice(0, b.length - 1);
            case 3:
                return b.slice(1, b.length - 1);
            case 0:
                return b;
            default:
                throw Error("Unknown ignore mode: " + a.a);
        }
    }

    function Pg(a) {
        var b = [];
        Dg(a.getElementsByTagName("p"), function (c) {
            100 <= Qg(c) && b.push(c)
        });
        return b
    }

    function Qg(a) {
        if (3 == a.nodeType) return a.length;
        if (1 != a.nodeType || "SCRIPT" == a.tagName) return 0;
        var b = 0;
        Dg(a.childNodes, function (c) {
            b += Qg(c)
        });
        return b
    }

    function Rg(a) {
        return 0 == a.length || isNaN(a[0]) ? a : "\\" + (30 + parseInt(a[0], 10)) + " " + a.substring(1)
    };

    function Sg(a) {
        if (!a) return null;
        var b = z(a, 7);
        if (z(a, 1) || a.Y() || 0 < z(a, 4).length) {
            var c = a.Y(), d = z(a, 1), e = z(a, 4);
            b = z(a, 2);
            var f = z(a, 5);
            a = Tg(z(a, 6));
            var g = "";
            d && (g += d);
            c && (g += "#" + Rg(c));
            if (e) for (c = 0; c < e.length; c++) g += "." + Rg(e[c]);
            b = (e = g) ? new Mg(e, b, f, a) : null
        } else b = b ? new Mg(b, z(a, 2), z(a, 5), Tg(z(a, 6))) : null;
        return b
    }

    var Ug = {1: 1, 2: 2, 3: 3, 0: 0};

    function Tg(a) {
        return null == a ? a : Ug[a]
    }

    var Vg = {1: 0, 2: 1, 3: 2, 4: 3};

    function Wg() {
    };

    function Xg(a, b, c) {
        var d = Uf(c, b + 1);
        return !La(a, function (e) {
            return e.left < d.right && d.left < e.right && e.top < d.bottom && d.top < e.bottom
        })
    };

    function Yg() {
        this.a = new bg
    }

    Yg.prototype.set = function (a, b) {
        var c = this.a.get(a);
        c || (c = new Vf, this.a.set(a, c));
        c.add(b)
    };

    function Zg(a, b) {
        function c() {
            d.push({anchor: e.anchor, position: e.position});
            return e.anchor == b.anchor && e.position == b.position
        }

        for (var d = [], e = a; e;) {
            switch (e.position) {
                case 1:
                    if (c()) return d;
                    e.position = 2;
                case 2:
                    if (c()) return d;
                    if (e.anchor.firstChild) {
                        e = {anchor: e.anchor.firstChild, position: 1};
                        continue
                    } else e.position = 3;
                case 3:
                    if (c()) return d;
                    e.position = 4;
                case 4:
                    if (c()) return d
            }
            for (; e && !e.anchor.nextSibling && e.anchor.parentNode != e.anchor.ownerDocument.body;) {
                e = {anchor: e.anchor.parentNode, position: 3};
                if (c()) return d;
                e.position = 4;
                if (c()) return d
            }
            e && e.anchor.nextSibling ? e = {anchor: e.anchor.nextSibling, position: 1} : e = null
        }
        return d
    };

    function $g(a, b) {
        this.b = a;
        this.a = b
    }

    function ah(a, b) {
        var c = new Yg, d = new Vf;
        b.forEach(function (e) {
            if (B(e, xe, 1)) {
                e = B(e, xe, 1);
                if (B(e, N, 1) && B(B(e, N, 1), L, 1) && B(e, N, 2) && B(B(e, N, 2), L, 1)) {
                    var f = bh(a, B(B(e, N, 1), L, 1)), g = bh(a, B(B(e, N, 2), L, 1));
                    if (f && g) for (f = ea(Zg({anchor: f, position: z(B(e, N, 1), 2)}, {
                        anchor: g,
                        position: z(B(e, N, 2), 2)
                    })), g = f.next(); !g.done; g = f.next()) g = g.value, c.set(za(g.anchor), g.position)
                }
                B(e, N, 3) && B(B(e, N, 3), L, 1) && (f = bh(a, B(B(e, N, 3), L, 1))) && c.set(za(f), z(B(e, N, 3), 2))
            } else B(e, ye, 2) ? ch(a, B(e, ye, 2), c) : B(e, ze, 3) && dh(a, B(e, ze, 3), d)
        });
        return new $g(c, d)
    }

    function ch(a, b, c) {
        B(b, L, 1) && (a = eh(a, B(b, L, 1))) && a.forEach(function (d) {
            d = za(d);
            c.set(d, 1);
            c.set(d, 4);
            c.set(d, 2);
            c.set(d, 3)
        })
    }

    function dh(a, b, c) {
        B(b, L, 1) && (a = eh(a, B(b, L, 1))) && a.forEach(function (d) {
            c.add(za(d))
        })
    }

    function bh(a, b) {
        return (a = eh(a, b)) && 0 < a.length ? a[0] : null
    }

    function eh(a, b) {
        return (b = Sg(b)) ? Ng(b, a) : null
    };

    function fh(a, b) {
        if (!a) return !1;
        a = pc(a, b);
        if (!a) return !1;
        a = a.cssFloat || a.styleFloat;
        return "left" == a || "right" == a
    }

    function gh(a) {
        for (a = a.previousSibling; a && 1 != a.nodeType;) a = a.previousSibling;
        return a ? a : null
    }

    function hh(a) {
        return !!a.nextSibling || !!a.parentNode && hh(a.parentNode)
    };

    function ih(a, b) {
        return a && null != z(a, 4) && b[z(B(a, Be, 4), 2)] ? !1 : !0
    }

    function jh(a) {
        var b = {};
        a && z(a, 6).forEach(function (c) {
            b[c] = !0
        });
        return b
    }

    function kh(a, b, c, d) {
        this.a = p;
        this.u = a;
        this.b = b;
        this.j = d || null;
        this.o = (this.g = c) ? ah(p.document, C(c, ve, 5)) : ah(p.document, []);
        this.c = 0;
        this.f = !1
    }

    function lh(a) {
        return new Wg(mh(a).numAutoAdsPlaced || 0, C(a.b, Ce, 1).length)
    }

    function nh(a, b) {
        if (a.f) return !0;
        a.f = !0;
        var c = C(a.b, Ce, 1);
        a.c = 0;
        var d = jh(a.g);
        var e = (e = a.g) ? Oa(z(e, 11), 1) : !1;
        var f;
        if (f = !e && B(a.b, Me, 15) && Lb(B(a.b, Me, 15), 12)) a:{
            f = ag(a.a);
            f = null !== f ? C(f, Yf, 5) : null;
            var g = ag(a.a);
            var h = null != g ? B(g, Wf, 6) || null : null;
            if (null == f) f = !1; else {
                var k = g = 4;
                h && (g = z(h, 1) || g, k = z(h, 3) || k);
                h = new Vf([2, 1, 0]);
                B(a.b, Me, 15) && Lb(B(a.b, Me, 15), 15) && h.add(4);
                for (var m = [], n = 0; n < f.length; n++) {
                    var r = mh(a).numAutoAdsPlaced || 0;
                    var w = ag(a.a);
                    w = null !== w && null != z(w, 8) ? z(w, 8) : 0;
                    if (r + w >= g) {
                        f = !0;
                        break a
                    }
                    r =
                        z(f[n], 1);
                    if (null == r) break;
                    w = c[r];
                    var u = B(f[n], Xf, 2);
                    null != u && null != Jb(u, 1) && null != Jb(u, 2) && null != Jb(u, 3) && (u = new Tf(Jb(u, 1), Jb(u, 2), Jb(u, 3)), Xg(m, k, u) && (r = oh(a, w, r, b, d, h), null != r && null != r.W && (r = r.W.getBoundingClientRect(), m.push(r))))
                }
                f = 0 < (mh(a).numAutoAdsPlaced || 0)
            }
        }
        if (f) return !0;
        f = ag(a.a);
        if (null !== f && Lb(f, 2)) return mh(a).eatf = !0, Sf(7, [!0, 0, !1]), !0;
        f = new Vf([2]);
        !e && B(a.b, Me, 15) && Lb(B(a.b, Me, 15), 15) && f.add(4);
        for (e = 0; e < c.length; e++) if (oh(a, c[e], e, b, d, f)) return !0;
        Sf(7, [!1, a.c, !1]);
        return !1
    }

    function oh(a, b, c, d, e, f) {
        if (!B(b, Be, 4) || !f.contains(z(B(b, Be, 4), 1)) || 1 !== z(b, 8) || !ih(b, e)) return null;
        a.c++;
        if (b = ph(a, b, d, e)) d = mh(a), d.placement = c, d.numAutoAdsPlaced || (d.numAutoAdsPlaced = 0), d.numAutoAdsPlaced++, Sf(7, [!1, a.c, !0]);
        return b
    }

    function ph(a, b, c, d) {
        if (!ih(b, d) || 1 != z(b, 8)) return null;
        d = B(b, L, 1);
        if (!d) return null;
        d = Sg(d);
        if (!d) return null;
        d = Ng(d, a.a.document);
        if (0 == d.length) return null;
        d = d[0];
        var e = z(b, 2);
        e = Vg[e];
        e = void 0 === e ? null : e;
        var f;
        if (!(f = null == e)) {
            a:{
                f = a.a;
                switch (e) {
                    case 0:
                        f = fh(gh(d), f);
                        break a;
                    case 3:
                        f = fh(d, f);
                        break a;
                    case 2:
                        var g = d.lastChild;
                        f = fh(g ? 1 == g.nodeType ? g : gh(g) : null, f);
                        break a
                }
                f = !1
            }
            if (c = !f && !(!c && 2 == e && !hh(d))) c = 1 == e || 2 == e ? d : d.parentNode, c = !(c && !Eg(c) && 0 >= c.offsetWidth);
            f = !c
        }
        if (!(c = f)) {
            c = a.o;
            f = z(b, 2);
            g =
                za(d);
            g = c.b.a.get(g);
            if (!(g = g ? g.contains(f) : !1)) a:{
                if (c.a.contains(za(d))) switch (f) {
                    case 2:
                    case 3:
                        g = !0;
                        break a;
                    default:
                        g = !1;
                        break a
                }
                for (f = d.parentElement; f;) {
                    if (c.a.contains(za(f))) {
                        g = !0;
                        break a
                    }
                    f = f.parentElement
                }
                g = !1
            }
            c = g
        }
        if (c) return null;
        c = B(b, Ae, 3);
        f = {};
        c && (f.Fa = z(c, 1), f.qa = z(c, 2), f.clearBoth = !!Kb(c, 3));
        c = B(b, Be, 4) && z(B(b, Be, 4), 2) ? z(B(b, Be, 4), 2) : null;
        c = Hf(c);
        b = null == z(b, 12) ? null : z(b, 12);
        b = Gf(a.j, c, null == b ? null : new Ff(null, {google_ml_rank: b}));
        c = a.a;
        a = a.u;
        var h = c.document, k = f.clearBoth || !1;
        g = fc((new gc(h)).a,
            "DIV");
        var m = g.style;
        m.width = "100%";
        m.height = "auto";
        m.clear = k ? "both" : "none";
        k = g.style;
        k.textAlign = "center";
        f.Qa && Jg(k, f.Qa);
        h = fc((new gc(h)).a, "INS");
        k = h.style;
        k.display = "block";
        k.margin = "auto";
        k.backgroundColor = "transparent";
        f.Fa && (k.marginTop = f.Fa);
        f.qa && (k.marginBottom = f.qa);
        f.Ha && Jg(k, f.Ha);
        g.appendChild(h);
        f = {ia: g, W: h};
        f.W.setAttribute("data-ad-format", "auto");
        g = [];
        if (h = b && b.ra) f.ia.className = h.join(" ");
        h = f.W;
        h.className = "adsbygoogle";
        h.setAttribute("data-ad-client", a);
        g.length && h.setAttribute("data-ad-channel",
            g.join("+"));
        a:{
            try {
                var n = f.ia;
                var r = void 0 === r ? 0 : r;
                if (J(313)) {
                    r = void 0 === r ? 0 : r;
                    var w = Gg(d, e, r);
                    if (w.G) {
                        var u = w.G;
                        for (d = u; d = w.da(d);) u = d;
                        var D = {anchor: u, position: w.ea}
                    } else D = {anchor: d, position: e};
                    n["google-ama-order-assurance"] = r;
                    Fg(n, D.anchor, D.position)
                } else Fg(n, d, e);
                b:{
                    var v = f.W;
                    v.setAttribute("data-adsbygoogle-status", "reserved");
                    v.className += " adsbygoogle-noablate";
                    n = {element: v};
                    var M = b && b.ya;
                    if (v.hasAttribute("data-pub-vars")) {
                        try {
                            M = JSON.parse(v.getAttribute("data-pub-vars"))
                        } catch (Ka) {
                            break b
                        }
                        v.removeAttribute("data-pub-vars")
                    }
                    M &&
                    (n.params = M);
                    (c.adsbygoogle = c.adsbygoogle || []).push(n)
                }
            } catch (Ka) {
                (v = f.ia) && v.parentNode && (M = v.parentNode, M.removeChild(v), Eg(M) && (M.style.display = M.getAttribute("data-init-display") || "none"));
                v = !1;
                break a
            }
            v = !0
        }
        return v ? f : null
    }

    function mh(a) {
        return a.a.google_ama_state = a.a.google_ama_state || {}
    };

    function qh() {
        this.b = new rh(this);
        this.a = 0
    }

    qh.prototype.resolve = function (a) {
        sh(this);
        this.a = 1;
        this.f = a;
        th(this.b)
    };
    qh.prototype.reject = function (a) {
        sh(this);
        this.a = 2;
        this.c = a;
        th(this.b)
    };

    function sh(a) {
        if (0 != a.a) throw Error("Already resolved/rejected.");
    }

    function rh(a) {
        this.a = a
    }

    rh.prototype.then = function (a, b) {
        if (this.b) throw Error("Then functions already set.");
        this.b = a;
        this.c = b;
        th(this)
    };

    function th(a) {
        switch (a.a.a) {
            case 0:
                break;
            case 1:
                a.b && a.b(a.a.f);
                break;
            case 2:
                a.c && a.c(a.a.c);
                break;
            default:
                throw Error("Unhandled deferred state.");
        }
    };

    function uh(a, b) {
        this.exception = b
    }

    function vh(a, b) {
        this.c = p;
        this.a = a;
        this.b = b
    }

    vh.prototype.start = function () {
        this.f()
    };
    vh.prototype.f = function () {
        try {
            switch (this.c.document.readyState) {
                case "complete":
                case "interactive":
                    nh(this.a, !0);
                    wh(this);
                    break;
                default:
                    nh(this.a, !1) ? wh(this) : this.c.setTimeout(Ea(this.f, this), 100)
            }
        } catch (a) {
            wh(this, a)
        }
    };

    function wh(a, b) {
        try {
            a.b.resolve(new uh(lh(a.a), b))
        } catch (c) {
            a.b.reject(c)
        }
    };

    function xh(a) {
        Lf(a, {atf: 1})
    }

    function yh(a, b) {
        (a.google_ama_state = a.google_ama_state || {}).exception = b;
        Lf(a, {atf: 0})
    };

    function zh() {
        this.debugCard = null;
        this.debugCardRequested = !1
    };

    function Ah(a, b) {
        if (!a) return !1;
        a = a.hash;
        if (!a || !a.indexOf) return !1;
        if (-1 != a.indexOf(b)) return !0;
        b = Bh(b);
        return "go" != b && -1 != a.indexOf(b) ? !0 : !1
    }

    function Bh(a) {
        var b = "";
        be(a.split("_"), function (c) {
            b += c.substr(0, 2)
        });
        return b
    };var Ch = {
        13: "0.001",
        22: "0.01",
        24: "0.05",
        28: "0.001",
        29: "0.01",
        60: "0.03",
        66: "0.1",
        79: "1200",
        82: "3",
        98: "0.01",
        118: "false",
        126: "0.001",
        128: "false",
        129: "0.02",
        136: "0.02",
        137: "0.01",
        149: "0",
        150: "1000",
        155: "0.06",
        177: "0.02",
        179: "100",
        180: "20"
    };
    var Dh = null;

    function Eh() {
        this.a = Ch
    };

    function Fh(a, b, c) {
        var d = "script";
        d = void 0 === d ? "" : d;
        var e = a.createElement("link");
        try {
            e.rel = "preload";
            if (gb("preload", "stylesheet")) var f = Za(b).toString(); else {
                if (b instanceof Wa) var g = Za(b).toString(); else {
                    if (b instanceof jb) var h = mb(b); else {
                        if (b instanceof jb) var k = b; else b = "object" == typeof b && b.b ? b.a() : String(b), nb.test(b) || (b = "about:invalid#zClosurez"), k = new jb(kb, b);
                        h = mb(k)
                    }
                    g = h
                }
                f = g
            }
            e.href = f
        } catch (m) {
            return
        }
        d && (e.as = d);
        c && e.setAttribute("nonce", c);
        if (a = a.getElementsByTagName("head")[0]) try {
            a.appendChild(e)
        } catch (m) {
        }
    }
    ;

    function Gh(a) {
        var b = {}, c = {};
        return c.enable_page_level_ads = (b.pltais = !0, b), c.google_ad_client = a, c
    };

    function Hh(a) {
        if (!a) return "";
        (a = a.toLowerCase()) && "ca-" != a.substring(0, 3) && (a = "ca-" + a);
        return a
    };

    function Ih(a, b, c) {
        return Jh(a, void 0 === c ? "" : c, function (d) {
            return La(C(d, Vb, 2), function (e) {
                return z(e, 1) === b
            })
        })
    }

    function Kh(a, b, c) {
        c = void 0 === c ? "" : c;
        var d = le(a) || a;
        return Lh(d, b) ? !0 : Jh(a, c, function (e) {
            return La(z(e, 3), function (f) {
                return f === b
            })
        })
    }

    function Mh(a) {
        return Jh(p, void 0 === a ? "" : a, function () {
            return !0
        })
    }

    function Lh(a, b) {
        a = (a = (a = a.location && a.location.hash) && a.match(/forced_clientside_labs=([\d,]+)/)) && a[1];
        return !!a && Oa(a.split(","), b.toString())
    }

    function Jh(a, b, c) {
        a = le(a) || a;
        var d = Nh(a);
        b && (b = Hh(String(b)));
        return Ta(d, function (e, f) {
            return Object.prototype.hasOwnProperty.call(d, f) && (!b || b === f) && c(e)
        })
    }

    function Nh(a) {
        a = Oh(a);
        var b = {};
        be(a, function (c, d) {
            try {
                var e = new Tb(c);
                b[d] = e
            } catch (f) {
            }
        });
        return b
    }

    function Oh(a) {
        try {
            var b = a.localStorage.getItem("google_adsense_settings");
            if (!b) return {};
            var c = JSON.parse(b);
            return c !== Object(c) ? {} : Sa(c, function (d, e) {
                return Object.prototype.hasOwnProperty.call(c, e) && "string" === typeof e && "array" == xa(d)
            })
        } catch (d) {
            return {}
        }
    };

    function Ph() {
        this.b = function () {
        };
        this.a = function () {
            return []
        }
    }

    function Qh(a, b, c) {
        a.b = function (d) {
            Td(Gd, b, function () {
                return []
            })(d, c)
        };
        a.a = function () {
            return Td(Hd, b, function () {
                return []
            })(c)
        }
    }

    wa(Ph);
    var Rh = {i: "368226950", s: "368226951"}, Sh = {i: "368226960", s: "368226961"},
        Th = {i: "368226470", V: "368226471"}, Uh = {i: "368226480", V: "368226481"},
        Vh = {i: "368226500", s: "368226501"}, Wh = {i: "36998750", s: "36998751"},
        Xh = {A: "20040067", i: "20040068", oa: "1337"}, Yh = {i: "21060548", A: "21060549"},
        Zh = {i: "21060623", A: "21060624"}, $h = {i: "21062271", A: "21062272"};

    function ai(a) {
        return Tc && !!a.google_disable_experiments
    }

    ie();

    function bi(a) {
        var b = Kh(p, 12, a.google_ad_client);
        a = "google_ad_host" in a;
        var c = me(p, Rh.s), d = Ah(p.location, "google_ads_preview");
        return b && !a && c || d
    }

    function ci(a) {
        if (p.google_apltlad || ke(p) != p || !a.google_ad_client) return null;
        var b = bi(a), c = !me(p, Th.V);
        if (!b && !c) return null;
        p.google_apltlad = !0;
        var d = Gh(a.google_ad_client), e = d.enable_page_level_ads;
        F(a, function (f, g) {
            re[g] && "google_ad_client" != g && (e[g] = f)
        });
        b ? e.google_ad_channel = "AutoInsertAutoAdCode" : c && (e.google_pgb_reactive = 7, "google_ad_section" in a || "google_ad_region" in a) && (e.google_ad_section = a.google_ad_section || a.google_ad_region);
        return d
    }

    function di(a) {
        return ya(a.enable_page_level_ads) && 7 == a.enable_page_level_ads.google_pgb_reactive
    };

    function Af(a) {
        try {
            var b = K(p).eids || [];
            null != b && 0 < b.length && (a.eid = b.join(","))
        } catch (c) {
        }
    }

    function zf(a) {
        a.shv = Sc()
    }

    sf.Ca(!Tc);

    function ei(a, b) {
        return kg(b, a) + R(b, a, "height", G)
    };

    function fi() {
        var a = {};
        this[3] = (a[23] = function (b) {
            return Ih(E, parseInt(b, 10))
        }, a[24] = function (b) {
            return Kh(E, parseInt(b, 10))
        }, a);
        this[4] = {};
        this[5] = {}
    }

    wa(fi);

    function gi(a) {
        y(this, a, hi, null)
    }

    q(gi, x);

    function ii(a) {
        y(this, a, null, null)
    }

    q(ii, x);
    var hi = [1];

    function ji(a) {
        var b = new ii;
        return Ob(b, 1, a)
    }

    function ki(a, b) {
        return Ob(a, 2, b)
    }

    function li(a, b) {
        Pb(a, ii, 1);
        var c = a.a[1];
        c || (c = a.a[1] = []);
        b = b ? b : new ii;
        a = z(a, 1);
        c.push(b);
        a.push(Qb(b))
    };

    function mi(a, b) {
        this.start = a < b ? a : b;
        this.a = a < b ? b : a
    };

    function ni(a) {
        this.b = new mi(0, 999);
        this.a = a
    }

    function oi(a, b) {
        b = void 0 === b ? 0 : b;
        b = 0 != b ? "google_experiment_mod" + b : "google_experiment_mod";
        var c = xc(a, b);
        return null === c ? Ac(a, b) : c
    }

    function pi(a) {
        var b = window;
        a:{
            try {
                if (b.localStorage) {
                    var c = b.localStorage.getItem("google_experiment_mod");
                    break a
                }
            } catch (g) {
            }
            c = null
        }
        var d = c || "";
        c = null;
        try {
            if (c = Sb(gi, d), d) {
                var e = Sb(gi, d);
                li(e, ki(ji(1), -1));
                e.j()
            }
        } catch (g) {
            qi(d), c = new gi
        }
        e = C(c, ii, 1);
        if (e = Ma(e, function (g) {
            return A(g, 1, 0) === a
        })) {
            var f = A(e, 2, 0);
            if (null === f || isNaN(f)) qi(d); else return f
        }
        d = yc(b);
        if (null === d) return null;
        e ? Ob(e, 2, d) : li(c, ki(ji(a), d));
        return zc(b, "google_experiment_mod", c.j()) ? d : null
    }

    function qi(a) {
        .01 > Math.random() && Nc({data: a}, "ls_tamp")
    };var ri = new ni(5);

    function si(a) {
        a = void 0 === a ? p : a;
        return a.ggeac || (a.ggeac = {})
    };

    function ti(a, b) {
        a = ua(a);
        a = "function" === typeof a ? a() : a;
        return typeof a === b ? a : void 0
    }

    function ui() {
        var a = {};
        this[3] = (a[8] = function (b) {
            return !!ua(b)
        }, a[9] = function (b) {
            b = ua(b);
            return "function" == xa(b) && Fc(b)
        }, a[10] = function () {
            return window == window.top
        }, a[6] = function (b) {
            return Oa(Ph.h().a(), parseInt(b, 10))
        }, a[27] = function (b) {
            b = ti(b, "boolean");
            return void 0 !== b ? b : void 0
        }, a);
        a = {};
        this[4] = (a[3] = function () {
            return Gc()
        }, a[6] = function (b) {
            b = ti(b, "number");
            return void 0 !== b ? b : void 0
        }, a);
        a = {};
        this[5] = (a[2] = function () {
            return window.location.href
        }, a[3] = function () {
            try {
                return window.top.location.hash
            } catch (b) {
                return ""
            }
        },
            a[4] = function (b) {
                b = ti(b, "string");
                return void 0 !== b ? b : void 0
            }, a)
    }

    wa(ui);

    function vi(a) {
        y(this, a, wi, null)
    }

    q(vi, x);
    var wi = [2];
    vi.prototype.Y = function () {
        return A(this, 1, 0)
    };
    vi.prototype.X = function () {
        return A(this, 7, 0)
    };

    function xi(a) {
        y(this, a, yi, null)
    }

    q(xi, x);
    var yi = [2];
    xi.prototype.X = function () {
        return A(this, 5, 0)
    };

    function zi(a) {
        y(this, a, Ai, null)
    }

    q(zi, x);

    function Bi(a) {
        y(this, a, Ci, null)
    }

    q(Bi, x);
    var Ai = [1, 4, 2, 3], Ci = [2];
    Bi.prototype.X = function () {
        return A(this, 1, 0)
    };
    var Di = [12, 13];

    function Ei() {
    }

    Ei.prototype.G = function (a, b, c) {
        var d = this, e = void 0 === c ? {} : c;
        c = void 0 === e.ta ? !1 : e.ta;
        var f = void 0 === e.Pa ? {} : e.Pa;
        e = void 0 === e.Xa ? [] : e.Xa;
        this.a = a;
        this.g = c;
        this.f = f;
        a = {};
        this.b = (a[b] = e, a[4] = [], a);
        this.c = {};
        (b = cf()) && Ha(b.split(",") || [], function (g) {
            (g = parseInt(g, 10)) && (d.c[g] = !0)
        });
        return this
    };

    function Fi(a, b, c) {
        var d = [], e = Gi(a.a, b);
        if (e.length) {
            9 !== b && (a.a = Hi(a.a, b));
            var f = Oa(Di, b);
            Ha(e, function (g) {
                if (g = Ii(a, g, c)) {
                    var h = g.Y();
                    d.push(h);
                    Ji(a, h, f ? 4 : c);
                    var k = C(g, id, 2);
                    k && (f ? Ha(Cd(), function (m) {
                        return Ad(k, m)
                    }) : Ad(k, c))
                }
            })
        }
        return d
    }

    function Ji(a, b, c) {
        a.b[c] || (a.b[c] = []);
        a = a.b[c];
        Oa(a, b) ? Nc({eids: JSON.stringify(a), dup: b}, "gpt_dupeid") : a.push(b)
    }

    function Ki(a, b) {
        a.a.push.apply(a.a, fa(Ia(Ja(b, function (c) {
            return new Bi(c)
        }), function (c) {
            return !Oa(Di, c.X())
        })))
    }

    function Ii(a, b, c) {
        var d = md.h().a;
        if (!fd(B(b, Zc, 3), d)) return null;
        var e = C(b, vi, 2), f = e.length * A(b, 1, 0), g = A(b, 6, 0);
        if (g) return f = 2 == c ? pi(g) : oi(window, g), null === f && (f = Math.floor(1E3 * tc(window))), b = Li(b, f), !b || d && !fd(B(b, Zc, 3), d) ? null : Mi(a, [b], 1);
        c = d ? Ia(e, function (h) {
            return fd(B(h, Zc, 3), d)
        }) : e;
        return c.length ? (b = A(b, 4, 0)) ? Ni(a, b, f, c) : Mi(a, c, f / 1E3) : null
    }

    function Ni(a, b, c, d) {
        var e = null != a.f[b] ? a.f[b] : 1E3;
        if (0 >= e) return null;
        d = Mi(a, d, c / e);
        a.f[b] = d ? 0 : e - c;
        return d
    }

    function Mi(a, b, c) {
        var d = a.c, e = Ma(b, function (f) {
            return !!d[f.Y()]
        });
        return e ? e : a.g ? null : qc(b, c, !1)
    }

    function Oi(a, b) {
        I(Ed, function (c) {
            a.c[c] = !0
        }, b);
        I(Gd, function (c, d) {
            return Fi(a, c, d)
        }, b);
        I(Hd, function (c) {
            return (a.b[c] || []).concat(a.b[4])
        }, b);
        I(Qd, function (c) {
            return Ki(a, c)
        }, b)
    }

    wa(Ei);

    function Gi(a, b) {
        return (a = Ma(a, function (c) {
            return c.X() == b
        })) && C(a, xi, 2) || []
    }

    function Hi(a, b) {
        return Ia(a, function (c) {
            return c.X() != b
        })
    }

    function Li(a, b) {
        var c = C(a, vi, 2), d = c.length, e = A(a, 1, 0);
        a = A(a, 8, 0);
        var f = (b - a) % d;
        return b < a || b - a - f >= d * e - 1 ? null : c[f]
    };

    function Pi() {
        this.a = function () {
        }
    }

    wa(Pi);

    function Qi(a) {
        Pi.h().a(a)
    };

    function Ri(a, b, c, d) {
        var e = 1;
        d = void 0 === d ? si() : d;
        e = void 0 === e ? 0 : e;
        d.hasOwnProperty("init-done") ? (Td(Qd, d)(Ja(C(a, Bi, 2), function (f) {
            return Qb(f)
        })), Td(Rd, d)(Ja(C(a, id, 1), function (f) {
            return Qb(f)
        }), e), b && Td(Sd, d)(b), Si(d, e)) : (Oi(Ei.h().G(C(a, Bi, 2), e, c), d), Ud(d), Vd(d), Wd(d), Si(d, e), Ad(C(a, id, 1), e), nd = nd || !(!c || !c.Ma), Qi(ui.h()), b && Qi(b))
    }

    function Si(a, b) {
        a = void 0 === a ? si() : a;
        b = void 0 === b ? 0 : b;
        var c = a, d = b;
        d = void 0 === d ? 0 : d;
        Qh(Ph.h(), c, d);
        c = a;
        b = void 0 === b ? 0 : b;
        Yd(Xd.h(), c, b);
        Pi.h().a = Td(Sd, a);
        Xd.h().a()
    };

    function S(a, b) {
        b && a.push(b)
    }

    function Ti(a, b) {
        for (var c = [], d = 1; d < arguments.length; ++d) c[d - 1] = arguments[d];
        d = le(a) || a;
        d = (d = (d = d.location && d.location.hash) && (d.match(/google_plle=([\d,]+)/) || d.match(/deid=([\d,]+)/))) && d[1];
        return !!d && La(c, Fa(gb, d))
    }

    function Ui(a, b, c) {
        for (var d = 0; d < c.length; d++) if (Ti(a, c[d])) return c[d];
        return ai(a) ? null : qc(c, b)
    }

    function Vi(a, b, c, d, e, f) {
        f = void 0 === f ? 1 : f;
        for (var g = 0; g < e.length; g++) if (Ti(a, e[g])) return e[g];
        ai(a) ? c = null : (f = void 0 === f ? 1 : f, 0 >= d ? c = null : (g = new mi(c, c + d - 1), (d = d % f || d / f % e.length) || (d = b.b, d = !(d.start <= g.start && d.a >= g.a)), d ? c = null : (a = oi(a, b.a), c = null !== a && g.start <= a && g.a >= a ? e[Math.floor((a - c) / f) % e.length] : null)));
        return c
    };

    function Wi(a, b, c) {
        if (lc(a.document.getElementById(b).contentWindow)) a = a.document.getElementById(b).contentWindow, b = a.document, b.body && b.body.firstChild || (/Firefox/.test(navigator.userAgent) ? b.open("text/html", "replace") : b.open(), a.google_async_iframe_close = !0, b.write(c)); else {
            a = a.document.getElementById(b).contentWindow;
            c = String(c);
            b = ['"'];
            for (var d = 0; d < c.length; d++) {
                var e = c.charAt(d), f = e.charCodeAt(0), g = d + 1, h;
                if (!(h = wb[e])) {
                    if (!(31 < f && 127 > f)) if (f = e, f in xb) e = xb[f]; else if (f in wb) e = xb[f] = wb[f];
                    else {
                        h = f.charCodeAt(0);
                        if (31 < h && 127 > h) e = f; else {
                            if (256 > h) {
                                if (e = "\\x", 16 > h || 256 < h) e += "0"
                            } else e = "\\u", 4096 > h && (e += "0");
                            e += h.toString(16).toUpperCase()
                        }
                        e = xb[f] = e
                    }
                    h = e
                }
                b[g] = h
            }
            b.push('"');
            a.location.replace("javascript:" + b.join(""))
        }
    };var Xi = null;

    function T(a, b, c, d) {
        d = void 0 === d ? !1 : d;
        Q.call(this, a, b);
        this.Z = c;
        this.Na = d
    }

    na(T, Q);
    T.prototype.ga = function () {
        return this.Z
    };
    T.prototype.ba = function (a, b, c) {
        b.google_ad_resize || (c.style.height = this.height() + "px", b.rpe = !0)
    };

    function Yi(a) {
        return function (b) {
            return !!(b.Z & a)
        }
    };var Zi = Ab("script");

    function $i(a, b, c, d, e, f, g, h, k, m, n, r, w, u) {
        this.I = a;
        this.a = b;
        this.Z = void 0 === c ? null : c;
        this.c = void 0 === d ? null : d;
        this.T = void 0 === e ? null : e;
        this.b = void 0 === f ? null : f;
        this.f = void 0 === g ? null : g;
        this.o = void 0 === h ? !1 : h;
        this.u = void 0 === k ? !1 : k;
        this.P = void 0 === m ? null : m;
        this.$ = void 0 === n ? null : n;
        this.g = void 0 === r ? null : r;
        this.j = void 0 === w ? null : w;
        this.aa = void 0 === u ? null : u;
        this.U = this.L = this.K = null
    }

    function aj(a, b, c) {
        null != a.Z && (c.google_responsive_formats = a.Z);
        null != a.T && (c.google_safe_for_responsive_override = a.T);
        null != a.b && (!0 === a.b ? c.google_full_width_responsive_allowed = !0 : (c.google_full_width_responsive_allowed = !1, c.gfwrnwer = a.b));
        null != a.f && !0 !== a.f && (c.gfwrnher = a.f);
        a.o && (c.google_bfa = a.o);
        a.u && (c.ebfa = a.u);
        var d = a.j || c.google_ad_width;
        null != d && (c.google_resizing_width = d);
        d = a.g || c.google_ad_height;
        null != d && (c.google_resizing_height = d);
        d = a.a.R(b);
        var e = a.a.height();
        c.google_ad_resize ||
        (c.google_ad_width = d, c.google_ad_height = e, c.google_ad_format = a.a.ja(b), c.google_responsive_auto_format = a.I, null != a.c && (c.armr = a.c), c.google_ad_resizable = !0, c.google_override_format = 1, c.google_loader_features_used = 128, !0 === a.b && (c.gfwrnh = a.a.height() + "px"));
        null != a.P && (c.gfwroml = a.P);
        null != a.$ && (c.gfwromr = a.$);
        null != a.g && (c.gfwroh = a.g);
        null != a.j && (c.gfwrow = a.j);
        null != a.aa && (c.gfwroz = a.aa);
        null != a.K && (c.gml = a.K);
        null != a.L && (c.gmr = a.L);
        null != a.U && (c.gzi = a.U);
        b = ie();
        b = le(b) || b;
        Ah(b.location, "google_responsive_slot_debug") &&
        (c.ds = "outline:thick dashed " + (d && e ? !0 !== a.b || !0 !== a.f ? "#ffa500" : "#0f0" : "#f00") + " !important;");
        Ah(b.location, "google_responsive_dummy_ad") && (Oa([1, 2, 3, 4, 5, 6, 7, 8], a.I) || 1 === a.c) && 2 !== a.c && (a = JSON.stringify({
            googMsgType: "adpnt",
            key_value: [{key: "qid", value: "DUMMY_AD"}]
        }), c.dash = "<" + Zi + ">window.top.postMessage('" + a + "', '*');\n          </" + Zi + '>\n          <div id="dummyAd" style="width:' + d + "px;height:" + e + 'px;\n            background:#ddd;border:3px solid #f00;box-sizing:border-box;\n            color:#000;">\n            <p>Requested size:' +
            d + "x" + e + "</p>\n            <p>Rendered size:" + d + "x" + e + "</p>\n          </div>")
    };/*

 Copyright 2019 The AMP HTML Authors. All Rights Reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS-IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/
    var bj = {},
        cj = (bj.image_stacked = 1 / 1.91, bj.image_sidebyside = 1 / 3.82, bj.mobile_banner_image_sidebyside = 1 / 3.82, bj.pub_control_image_stacked = 1 / 1.91, bj.pub_control_image_sidebyside = 1 / 3.82, bj.pub_control_image_card_stacked = 1 / 1.91, bj.pub_control_image_card_sidebyside = 1 / 3.74, bj.pub_control_text = 0, bj.pub_control_text_card = 0, bj),
        dj = {},
        ej = (dj.image_stacked = 80, dj.image_sidebyside = 0, dj.mobile_banner_image_sidebyside = 0, dj.pub_control_image_stacked = 80, dj.pub_control_image_sidebyside = 0, dj.pub_control_image_card_stacked =
            85, dj.pub_control_image_card_sidebyside = 0, dj.pub_control_text = 80, dj.pub_control_text_card = 80, dj),
        fj = {},
        gj = (fj.pub_control_image_stacked = 100, fj.pub_control_image_sidebyside = 200, fj.pub_control_image_card_stacked = 150, fj.pub_control_image_card_sidebyside = 250, fj.pub_control_text = 100, fj.pub_control_text_card = 150, fj);

    function hj(a) {
        var b = 0;
        a.C && b++;
        a.v && b++;
        a.w && b++;
        if (3 > b) return {B: "Tags data-matched-content-ui-type, data-matched-content-columns-num and data-matched-content-rows-num should be set together."};
        b = a.C.split(",");
        var c = a.w.split(",");
        a = a.v.split(",");
        if (b.length !== c.length || b.length !== a.length) return {B: 'Lengths of parameters data-matched-content-ui-type, data-matched-content-columns-num and data-matched-content-rows-num must match. Example: \n data-matched-content-rows-num="4,2"\ndata-matched-content-columns-num="1,6"\ndata-matched-content-ui-type="image_stacked,image_card_sidebyside"'};
        if (2 < b.length) return {B: "The parameter length of attribute data-matched-content-ui-type, data-matched-content-columns-num and data-matched-content-rows-num is too long. At most 2 parameters for each attribute are needed: one for mobile and one for desktop, while you are providing " + (b.length + ' parameters. Example: \n data-matched-content-rows-num="4,2"\ndata-matched-content-columns-num="1,6"\ndata-matched-content-ui-type="image_stacked,image_card_sidebyside".')};
        for (var d = [], e = [], f = 0; f < b.length; f++) {
            var g =
                Number(c[f]);
            if (isNaN(g) || 0 === g) return {B: "Wrong value '" + c[f] + "' for data-matched-content-rows-num."};
            d.push(g);
            g = Number(a[f]);
            if (isNaN(g) || 0 === g) return {B: "Wrong value '" + a[f] + "' for data-matched-content-columns-num."};
            e.push(g)
        }
        return {w: d, v: e, wa: b}
    }

    function ij(a) {
        return 1200 <= a ? {width: 1200, height: 600} : 850 <= a ? {
            width: a,
            height: Math.floor(.5 * a)
        } : 550 <= a ? {width: a, height: Math.floor(.6 * a)} : 468 <= a ? {
            width: a,
            height: Math.floor(.7 * a)
        } : {width: a, height: Math.floor(3.44 * a)}
    };var jj = ["google_content_recommendation_ui_type", "google_content_recommendation_columns_num", "google_content_recommendation_rows_num"];

    function kj(a, b) {
        Q.call(this, a, b)
    }

    na(kj, Q);
    kj.prototype.R = function (a) {
        return Math.min(1200, Math.max(this.minWidth(), Math.round(a)))
    };

    function lj(a, b) {
        mj(a, b);
        if ("pedestal" == b.google_content_recommendation_ui_type) return new $i(9, new kj(a, Math.floor(a * b.google_phwr)));
        var c = jc();
        468 > a ? c ? (c = a - 8 - 8, c = Math.floor(c / 1.91 + 70) + Math.floor(11 * (c * cj.mobile_banner_image_sidebyside + ej.mobile_banner_image_sidebyside) + 96), a = {
            O: a,
            M: c,
            v: 1,
            w: 12,
            C: "mobile_banner_image_sidebyside"
        }) : (a = ij(a), a = {
            O: a.width,
            M: a.height,
            v: 1,
            w: 13,
            C: "image_sidebyside"
        }) : (a = ij(a), a = {O: a.width, M: a.height, v: 4, w: 2, C: "image_stacked"});
        nj(b, a);
        return new $i(9, new kj(a.O, a.M))
    }

    function oj(a, b) {
        mj(a, b);
        var c = hj({
            w: b.google_content_recommendation_rows_num,
            v: b.google_content_recommendation_columns_num,
            C: b.google_content_recommendation_ui_type
        });
        if (c.B) a = {O: 0, M: 0, v: 0, w: 0, C: "image_stacked", B: c.B}; else {
            var d = 2 === c.wa.length && 468 <= a ? 1 : 0;
            var e = c.wa[d];
            e = 0 === e.indexOf("pub_control_") ? e : "pub_control_" + e;
            var f = gj[e];
            for (var g = c.v[d]; a / g < f && 1 < g;) g--;
            f = g;
            c = c.w[d];
            d = Math.floor(((a - 8 * f - 8) / f * cj[e] + ej[e]) * c + 8 * c + 8);
            a = 1500 < a ? {width: 0, height: 0, na: "Calculated slot width is too large: " + a} :
                1500 < d ? {width: 0, height: 0, na: "Calculated slot height is too large: " + d} : {
                    width: a,
                    height: d
                };
            a = a.na ? {O: 0, M: 0, v: 0, w: 0, C: e, B: a.na} : {O: a.width, M: a.height, v: f, w: c, C: e}
        }
        if (a.B) throw new O(a.B);
        nj(b, a);
        return new $i(9, new kj(a.O, a.M))
    }

    function mj(a, b) {
        if (0 >= a) throw new O("Invalid responsive width from Matched Content slot " + b.google_ad_slot + ": " + a + ". Please ensure to put this Matched Content slot into a non-zero width div container.");
    }

    function nj(a, b) {
        a.google_content_recommendation_ui_type = b.C;
        a.google_content_recommendation_columns_num = b.v;
        a.google_content_recommendation_rows_num = b.w
    };

    function pj(a, b) {
        Q.call(this, a, b)
    }

    na(pj, Q);
    pj.prototype.R = function () {
        return this.minWidth()
    };
    pj.prototype.ba = function (a, b, c) {
        vg(a, c);
        b.google_ad_resize || (c.style.height = this.height() + "px", b.rpe = !0)
    };
    var qj = {
        "image-top": function (a) {
            return 600 >= a ? 284 + .414 * (a - 250) : 429
        }, "image-middle": function (a) {
            return 500 >= a ? 196 - .13 * (a - 250) : 164 + .2 * (a - 500)
        }, "image-side": function (a) {
            return 500 >= a ? 205 - .28 * (a - 250) : 134 + .21 * (a - 500)
        }, "text-only": function (a) {
            return 500 >= a ? 187 - .228 * (a - 250) : 130
        }, "in-article": function (a) {
            return 420 >= a ? a / 1.2 : 460 >= a ? a / 1.91 + 130 : 800 >= a ? a / 4 : 200
        }
    };

    function rj(a, b) {
        Q.call(this, a, b)
    }

    na(rj, Q);
    rj.prototype.R = function () {
        return Math.min(1200, this.minWidth())
    };

    function sj(a, b, c, d, e) {
        var f = e.google_ad_layout || "image-top";
        if ("in-article" == f && "false" != e.google_full_width_responsive) {
            var g = og(b, c, a, .2, e);
            if (!0 !== g) e.gfwrnwer = g; else if (g = P(b)) e.google_full_width_responsive_allowed = !0, c.parentElement && (tg(b, c), vg(b, c), a = g)
        }
        if (250 > a) throw new O("Fluid responsive ads must be at least 250px wide: availableWidth=" + a);
        a = Math.min(1200, Math.floor(a));
        if (d && "in-article" != f) {
            f = Math.ceil(d);
            if (50 > f) throw new O("Fluid responsive ads must be at least 50px tall: height=" +
                f);
            return new $i(11, new Q(a, f))
        }
        if ("in-article" != f && (d = e.google_ad_layout_key)) {
            f = "" + d;
            b = Math.pow(10, 3);
            if (d = (c = f.match(/([+-][0-9a-z]+)/g)) && c.length) {
                e = [];
                for (g = 0; g < d; g++) e.push(parseInt(c[g], 36) / b);
                b = e
            } else b = null;
            if (!b) throw new O("Invalid data-ad-layout-key value: " + f);
            f = (a + -725) / 1E3;
            c = 0;
            d = 1;
            e = b.length;
            for (g = 0; g < e; g++) c += b[g] * d, d *= f;
            f = Math.ceil(1E3 * c - -725 + 10);
            if (isNaN(f)) throw new O("Invalid height: height=" + f);
            if (50 > f) throw new O("Fluid responsive ads must be at least 50px tall: height=" + f);
            if (1200 < f) throw new O("Fluid responsive ads must be at most 1200px tall: height=" + f);
            return new $i(11, new Q(a, f))
        }
        d = qj[f];
        if (!d) throw new O("Invalid data-ad-layout value: " + f);
        c = yg(c, b);
        b = P(b);
        b = "in-article" !== f || c || a !== b ? Math.ceil(d(a)) : Math.ceil(1.25 * d(a));
        return new $i(11, "in-article" == f ? new rj(a, b) : new Q(a, b))
    };

    function tj(a) {
        return function (b) {
            for (var c = a.length - 1; 0 <= c; --c) if (!a[c](b)) return !1;
            return !0
        }
    }

    function uj(a, b, c) {
        for (var d = a.length, e = null, f = 0; f < d; ++f) {
            var g = a[f];
            if (b(g)) {
                if (!c || c(g)) return g;
                null === e && (e = g)
            }
        }
        return e
    };var U = [new T(970, 90, 2), new T(728, 90, 2), new T(468, 60, 2), new T(336, 280, 1), new T(320, 100, 2), new T(320, 50, 2), new T(300, 600, 4), new T(300, 250, 1), new T(250, 250, 1), new T(234, 60, 2), new T(200, 200, 1), new T(180, 150, 1), new T(160, 600, 4), new T(125, 125, 1), new T(120, 600, 4), new T(120, 240, 4), new T(120, 120, 1, !0)],
        vj = [U[6], U[12], U[3], U[0], U[7], U[14], U[1], U[8], U[10], U[4], U[15], U[2], U[11], U[5], U[13], U[9], U[16]];

    function wj(a, b, c, d, e) {
        "false" == e.google_full_width_responsive ? c = {
            l: a,
            m: 1
        } : "autorelaxed" == b && e.google_full_width_responsive || xj(b) || e.google_ad_resize ? (488 > P(c) && qg(c) && tg(c, d), b = pg(a, c, d, e), c = !0 !== b ? {
            l: a,
            m: b
        } : {l: P(c) || a, m: !0}) : c = {l: a, m: 2};
        b = c.m;
        return !0 !== b ? {l: a, m: b} : d.parentElement ? {l: c.l, m: b} : {l: a, m: b}
    }

    function yj(a, b, c, d, e) {
        var f = Bf(247, function () {
            return wj(a, b, c, d, e)
        }), g = f.l;
        f = f.m;
        var h = !0 === f, k = G(d.style.width), m = G(d.style.height), n = zj(g, b, c, d, e, h);
        g = n.N;
        h = n.H;
        var r = n.D, w = n.F, u = n.ga;
        n = n.va;
        var D = Aj(b, u), v, M = (v = R(d, c, "marginLeft", G)) ? v + "px" : "",
            Ka = (v = R(d, c, "marginRight", G)) ? v + "px" : "";
        v = R(d, c, "zIndex") || "";
        return new $i(D, g, u, null, n, f, h, r, w, M, Ka, m, k, v)
    }

    function xj(a) {
        return "auto" == a || /^((^|,) *(horizontal|vertical|rectangle) *)+$/.test(a)
    }

    function zj(a, b, c, d, e, f) {
        b = "auto" == b ? .25 >= a / Math.min(1200, P(c)) ? 4 : 3 : ng(b);
        var g = !1, h = !1;
        if (488 > P(c)) {
            var k = mg(d, c);
            var m = yg(d, c);
            g = !m && k;
            h = m && k
        }
        m = 488 > P(c);
        var n = [wg(a), Yi(b)];
        qg(c) || n.push(xg(m, c, d, h));
        null != e.google_max_responsive_height && n.push(Ag(e.google_max_responsive_height));
        var r = [function (u) {
            return !u.Na
        }];
        !g && !h || qg(c) || (g = Cg(c, d), r.push(Ag(g)));
        var w = m && !f && 3 === b && Bj(c) ? new T(a, Math.floor(a / 1.2), 1) : uj(vj.slice(0), tj(n), tj(r));
        if (!w) throw new O("No slot size for availableWidth=" + a);
        r = Bf(248,
            function () {
                var u;
                a:if (f) {
                    if (e.gfwrnh && (u = G(e.gfwrnh))) {
                        u = {N: new pj(a, u), H: !0, D: !1, F: !1};
                        break a
                    }
                    u = !1;
                    var D = hg(c).clientHeight, v = kg(d, c), M = c.google_lpabyc, Ka = Bg(d, c);
                    Ka && 2 < Ka && !c.google_bfabyc && (!M || v - M > D) && (D = .9 * hg(c).clientHeight, v = Math.min(D, Cj(c, d, e)), D && v == D && (v = c.google_pbfabyc, u = !v, v || (c.google_pbfabyc = kg(d, c) + D)));
                    D = a / 1.2;
                    if (qg(c)) v = D; else if (v = Math.min(D, Cj(c, d, e)), v < .5 * D || 100 > v) v = D;
                    J(282) && !yg(d, c) && (v = Math.max(v, .5 * hg(c).clientHeight));
                    u = {N: new pj(a, Math.floor(v)), H: v < D ? 102 : !0, D: !1, F: u}
                } else u =
                    {N: w, H: 100, D: !1, F: !1};
                return u
            });
        g = r.N;
        m = r.H;
        n = r.D;
        r = r.F;
        return "in-article" === e.google_ad_layout && Dj(c) ? {
            N: Ej(a, c, d, g, e),
            H: !1,
            D: !1,
            F: !1,
            ga: b,
            va: k
        } : {N: g, H: m, D: n, F: r, ga: b, va: k}
    }

    function Cj(a, b, c) {
        if (c.google_resizing_allowed || "true" == c.google_full_width_responsive) a = Infinity; else {
            c = Infinity;
            do {
                var d = R(b, a, "height", G);
                d && (c = Math.min(c, d));
                (d = R(b, a, "maxHeight", G)) && (c = Math.min(c, d))
            } while ((b = b.parentElement) && "HTML" != b.tagName);
            a = c
        }
        return a
    }

    function Aj(a, b) {
        if ("auto" == a) return 1;
        switch (b) {
            case 2:
                return 2;
            case 1:
                return 3;
            case 4:
                return 4;
            case 3:
                return 5;
            case 6:
                return 6;
            case 5:
                return 7;
            case 7:
                return 8
        }
        throw Error("bad mask");
    }

    function Ej(a, b, c, d, e) {
        var f = e.google_ad_height || R(c, b, "height", G);
        b = sj(a, b, c, f, e).a;
        return b.minWidth() * b.height() > a * d.height() ? new T(b.minWidth(), b.height(), 1) : d
    }

    function Dj(a) {
        return J(227) || a.location && "#hffwroe2etoq" == a.location.hash
    }

    function Bj(a) {
        return J(232) || a.location && "#affwroe2etoq" == a.location.hash
    };

    function Fj(a, b) {
        Q.call(this, a, b)
    }

    na(Fj, Q);
    Fj.prototype.R = function () {
        return this.minWidth()
    };
    Fj.prototype.ja = function (a) {
        return Q.prototype.ja.call(this, a) + "_0ads_al"
    };
    var Gj = [new Fj(728, 15), new Fj(468, 15), new Fj(200, 90), new Fj(180, 90), new Fj(160, 90), new Fj(120, 90)];

    function Hj(a, b, c) {
        var d = 250, e = 90;
        d = void 0 === d ? 130 : d;
        e = void 0 === e ? 30 : e;
        var f = uj(Gj, wg(a));
        if (!f) throw new O("No link unit size for width=" + a + "px");
        a = Math.min(a, 1200);
        f = f.height();
        b = Math.max(f, b);
        d = (new $i(10, new Fj(a, Math.min(b, 15 == f ? e : d)))).a;
        b = d.minWidth();
        d = d.height();
        15 <= c && (d = c);
        return new $i(10, new Fj(b, d))
    }

    function Ij(a, b, c, d) {
        if ("false" == d.google_full_width_responsive) return d.google_full_width_responsive_allowed = !1, d.gfwrnwer = 1, a;
        var e = pg(a, b, c, d);
        if (!0 !== e) return d.google_full_width_responsive_allowed = !1, d.gfwrnwer = e, a;
        e = P(b);
        if (!e) return a;
        d.google_full_width_responsive_allowed = !0;
        vg(b, c);
        return e
    };

    function Jj(a, b, c, d, e) {
        var f;
        (f = P(b)) ? 488 > P(b) ? b.innerHeight >= b.innerWidth ? (e.google_full_width_responsive_allowed = !0, vg(b, c), f = {
            l: f,
            m: !0
        }) : f = {l: a, m: 5} : f = {l: a, m: 4} : f = {l: a, m: 10};
        var g = f;
        f = g.l;
        g = g.m;
        if (!0 !== g || a == f) return new $i(12, new Q(a, d), null, null, !0, g, 100);
        a = zj(f, "auto", b, c, e, !0);
        return new $i(1, a.N, a.ga, 2, !0, g, a.H, a.D, a.F)
    };

    function Kj(a, b) {
        var c = b.google_ad_format;
        if ("autorelaxed" == c) {
            a:{
                if ("pedestal" != b.google_content_recommendation_ui_type) for (a = ea(jj), c = a.next(); !c.done; c = a.next()) if (null != b[c.value]) {
                    b = !0;
                    break a
                }
                b = !1
            }
            return b ? 9 : 5
        }
        if (xj(c)) return 1;
        if ("link" == c) return 4;
        if ("fluid" == c) {
            if (c = "in-article" === b.google_ad_layout) c = J(208) || J(227) || a.location && ("#hffwroe2etop" == a.location.hash || "#hffwroe2etoq" == a.location.hash);
            return c ? (Lj(b), 1) : 8
        }
        if (c = 27 === b.google_reactive_ad_format) c = J(266) || a.location && "#cefwroe2etoq" ==
            a.location.hash;
        if (c) return Lj(b), 1
    }

    function Mj(a, b, c, d, e) {
        e = b.offsetWidth || (c.google_ad_resize || (void 0 === e ? !1 : e)) && R(b, d, "width", G) || c.google_ad_width || 0;
        (J(310) || d.location && "#ooimne2e" == d.location.hash) && 4 === a && (c.google_ad_format = "auto", c.google_ad_slot = "", a = 1);
        var f = (f = Nj(a, e, b, c, d)) ? f : yj(e, c.google_ad_format, d, b, c);
        f.a.ba(d, c, b);
        aj(f, e, c);
        1 != a && (a = f.a.height(), b.style.height = a + "px")
    }

    function Nj(a, b, c, d, e) {
        var f = d.google_ad_height || R(c, e, "height", G);
        switch (a) {
            case 5:
                return a = Bf(247, function () {
                    return wj(b, d.google_ad_format, e, c, d)
                }), f = a.l, a = a.m, !0 === a && b != f && vg(e, c), !0 === a ? d.google_full_width_responsive_allowed = !0 : (d.google_full_width_responsive_allowed = !1, d.gfwrnwer = a), lj(f, d);
            case 9:
                return oj(b, d);
            case 4:
                return a = Ij(b, e, c, d), Hj(a, Cg(e, c), f);
            case 8:
                return sj(b, e, c, f, d);
            case 10:
                return Jj(b, e, c, f, d)
        }
    }

    function Lj(a) {
        a.google_ad_format = "auto";
        a.armr = 3
    };

    function V(a) {
        this.f = [];
        this.b = a || window;
        this.a = 0;
        this.c = null;
        this.g = 0
    }

    var Oj;
    l = V.prototype;
    l.Ja = function (a, b) {
        0 != this.a || 0 != this.f.length || b && b != window ? this.sa(a, b) : (this.a = 2, this.Aa(new Pj(a, window)))
    };
    l.sa = function (a, b) {
        this.f.push(new Pj(a, b || this.b));
        Qj(this)
    };
    l.Ra = function (a) {
        this.a = 1;
        if (a) {
            var b = Cf(188, Ea(this.za, this, !0));
            this.c = this.b.setTimeout(b, a)
        }
    };
    l.za = function (a) {
        a && ++this.g;
        1 == this.a && (null != this.c && (this.b.clearTimeout(this.c), this.c = null), this.a = 0);
        Qj(this)
    };
    l.Ya = function () {
        return !(!window || !Array)
    };
    l.La = function () {
        return this.g
    };

    function Qj(a) {
        var b = Cf(189, Ea(a.Za, a));
        a.b.setTimeout(b, 0)
    }

    l.Za = function () {
        if (0 == this.a && this.f.length) {
            var a = this.f.shift();
            this.a = 2;
            var b = Cf(190, Ea(this.Aa, this, a));
            a.a.setTimeout(b, 0);
            Qj(this)
        }
    };
    l.Aa = function (a) {
        this.a = 0;
        a.b()
    };

    function Rj(a) {
        try {
            return a.sz()
        } catch (b) {
            return !1
        }
    }

    function Sj(a) {
        return !!a && ("object" === typeof a || "function" === typeof a) && Rj(a) && ce(a.nq) && ce(a.nqa) && ce(a.al) && ce(a.rl)
    }

    function Tj() {
        if (Oj && Rj(Oj)) return Oj;
        var a = Lg(), b = a.google_jobrunner;
        return Sj(b) ? Oj = b : a.google_jobrunner = Oj = new V(a)
    }

    function Uj(a, b) {
        Tj().nq(a, b)
    }

    function Vj(a, b) {
        Tj().nqa(a, b)
    }

    V.prototype.nq = V.prototype.Ja;
    V.prototype.nqa = V.prototype.sa;
    V.prototype.al = V.prototype.Ra;
    V.prototype.rl = V.prototype.za;
    V.prototype.sz = V.prototype.Ya;
    V.prototype.tc = V.prototype.La;

    function Pj(a, b) {
        this.b = a;
        this.a = b
    };

    function Wj(a, b) {
        var c = le(b);
        if (c) {
            c = P(c);
            var d = pc(a, b) || {}, e = d.direction;
            if ("0px" === d.width && "none" != d.cssFloat) return -1;
            if ("ltr" === e && c) return Math.floor(Math.min(1200, c - a.getBoundingClientRect().left));
            if ("rtl" === e && c) return a = b.document.body.getBoundingClientRect().right - a.getBoundingClientRect().right, Math.floor(Math.min(1200, c - a - Math.floor((c - b.document.body.clientWidth) / 2)))
        }
        return -1
    };

    function Xj(a) {
        var b = this;
        this.a = a;
        a.google_iframe_oncopy || (a.google_iframe_oncopy = {
            handlers: {}, upd: function (c, d) {
                var e = Yj("rx", c), f = Number;
                a:{
                    if (c && (c = c.match("dt=([^&]+)")) && 2 == c.length) {
                        c = c[1];
                        break a
                    }
                    c = ""
                }
                f = f(c);
                f = (new Date).getTime() - f;
                e = e.replace(/&dtd=(\d+|-?M)/, "&dtd=" + (1E5 <= f ? "M" : 0 <= f ? f : "-M"));
                b.set(d, e);
                return e
            }
        });
        this.b = a.google_iframe_oncopy
    }

    Xj.prototype.set = function (a, b) {
        var c = this;
        this.b.handlers[a] = b;
        this.a.addEventListener && this.a.addEventListener("load", function () {
            var d = c.a.document.getElementById(a);
            try {
                var e = d.contentWindow.document;
                if (d.onload && e && (!e.body || !e.body.firstChild)) d.onload()
            } catch (f) {
            }
        }, !1)
    };

    function Yj(a, b) {
        var c = new RegExp("\\b" + a + "=(\\d+)"), d = c.exec(b);
        d && (b = b.replace(c, a + "=" + (+d[1] + 1 || 1)));
        return b
    }

    var Zj,
        ak = "var i=this.id,s=window.google_iframe_oncopy,H=s&&s.handlers,h=H&&H[i],w=this.contentWindow,d;try{d=w.document}catch(e){}if(h&&d&&(!d.body||!d.body.firstChild)){if(h.call){setTimeout(h,0)}else if(h.match){try{h=s.upd(h,i)}catch(e){}w.location.replace(h)}}";
    var W = ak;
    /[\x00&<>"']/.test(W) && (-1 != W.indexOf("&") && (W = W.replace(ab, "&amp;")), -1 != W.indexOf("<") && (W = W.replace(bb, "&lt;")), -1 != W.indexOf(">") && (W = W.replace(cb, "&gt;")), -1 != W.indexOf('"') && (W = W.replace(db, "&quot;")), -1 != W.indexOf("'") && (W = W.replace(eb, "&#39;")), -1 != W.indexOf("\x00") && (W = W.replace(fb, "&#0;")));
    ak = W;
    Zj = ak;
    var bk = {},
        ck = (bk.google_ad_modifications = !0, bk.google_analytics_domain_name = !0, bk.google_analytics_uacct = !0, bk.google_pause_ad_requests = !0, bk);

    function dk(a) {
        switch (a) {
            case "":
            case "Test":
            case "Real":
                return !0;
            default:
                return !1
        }
    }

    function ek(a) {
        this.c = E;
        this.b = void 0 === a ? !1 : a;
        this.a = new dc
    }

    function fk(a) {
        var b = a.a.get("__gads", "");
        return a.b && !dk(b) ? "Real" : b
    }

    ek.prototype.write = function (a) {
        var b = z(a, 1);
        if (this.b) {
            if (!dk(this.a.get("__gads", ""))) return;
            dk(b) || (b = "Real")
        }
        this.a.set("__gads", b, {Oa: z(a, 2) - this.c.Date.now() / 1E3, path: z(a, 3), domain: z(a, 4), Wa: !1})
    };
    var gk = /^\.google\.(com?\.)?[a-z]{2,3}$/, hk = /\.(cn|com\.bi|do|sl|ba|by|ma|am)$/;

    function ik(a) {
        return gk.test(a) && !hk.test(a)
    }

    var jk = p;

    function kk(a) {
        a = "https://adservice" + (a + "/adsid/integrator.js");
        var b = ["domain=" + encodeURIComponent(p.location.hostname)];
        X[3] >= +new Date && b.push("adsid=" + encodeURIComponent(X[1]));
        return a + "?" + b.join("&")
    }

    var X, Y;

    function lk() {
        jk = p;
        X = jk.googleToken = jk.googleToken || {};
        var a = +new Date;
        X[1] && X[3] > a && 0 < X[2] || (X[1] = "", X[2] = -1, X[3] = -1, X[4] = "", X[6] = "");
        Y = jk.googleIMState = jk.googleIMState || {};
        ik(Y[1]) || (Y[1] = ".google.com");
        Array.isArray(Y[5]) || (Y[5] = []);
        "boolean" !== typeof Y[6] && (Y[6] = !1);
        Array.isArray(Y[7]) || (Y[7] = []);
        "number" !== typeof Y[8] && (Y[8] = 0)
    }

    var mk = {
        ka: function () {
            return 0 < Y[8]
        }, Ta: function () {
            Y[8]++
        }, Ua: function () {
            0 < Y[8] && Y[8]--
        }, Va: function () {
            Y[8] = 0
        }, gb: function () {
            return !1
        }, Ka: function () {
            return Y[5]
        }, Ia: function (a) {
            try {
                a()
            } catch (b) {
                p.setTimeout(function () {
                    throw b;
                }, 0)
            }
        }, Sa: function () {
            if (!mk.ka()) {
                var a = p.document, b = function (e) {
                    e = kk(e);
                    a:{
                        try {
                            var f = ra();
                            break a
                        } catch (g) {
                        }
                        f = void 0
                    }
                    Fh(a, e, f);
                    f = a.createElement("script");
                    f.type = "text/javascript";
                    f.onerror = function () {
                        return p.processGoogleToken({}, 2)
                    };
                    e = hc(e);
                    vb(f, e);
                    try {
                        (a.head || a.body || a.documentElement).appendChild(f),
                            mk.Ta()
                    } catch (g) {
                    }
                }, c = Y[1];
                b(c);
                ".google.com" != c && b(".google.com");
                b = {};
                var d = (b.newToken = "FBT", b);
                p.setTimeout(function () {
                    return p.processGoogleToken(d, 1)
                }, 1E3)
            }
        }
    };

    function nk() {
        p.processGoogleToken = p.processGoogleToken || function (a, b) {
            var c = a;
            c = void 0 === c ? {} : c;
            b = void 0 === b ? 0 : b;
            a = c.newToken || "";
            var d = "NT" == a, e = parseInt(c.freshLifetimeSecs || "", 10), f = parseInt(c.validLifetimeSecs || "", 10),
                g = c["1p_jar"] || "";
            c = c.pucrd || "";
            lk();
            1 == b ? mk.Va() : mk.Ua();
            var h = jk.googleToken = jk.googleToken || {},
                k = 0 == b && a && "string" === typeof a && !d && "number" === typeof e && 0 < e && "number" === typeof f && 0 < f && "string" === typeof g;
            d = d && !mk.ka() && (!(X[3] >= +new Date) || "NT" == X[1]);
            var m = !(X[3] >= +new Date) &&
                0 != b;
            if (k || d || m) d = +new Date, e = d + 1E3 * e, f = d + 1E3 * f, 1E-5 > Math.random() && ae("https://pagead2.googlesyndication.com/pagead/gen_204?id=imerr&err=" + b, null), h[5] = b, h[1] = a, h[2] = e, h[3] = f, h[4] = g, h[6] = c, lk();
            if (k || !mk.ka()) {
                b = mk.Ka();
                for (a = 0; a < b.length; a++) mk.Ia(b[a]);
                b.length = 0
            }
        };
        lk();
        X[3] >= +new Date && X[2] >= +new Date || mk.Sa()
    };var ok = Ab("script");

    function pk() {
        E.google_sa_impl && !E.document.getElementById("google_shimpl") && (E.google_sa_queue = null, E.google_sl_win = null, E.google_sa_impl = null);
        if (!E.google_sa_queue) {
            E.google_sa_queue = [];
            E.google_sl_win = E;
            E.google_process_slots = function () {
                return qk(E)
            };
            var a = rk();
            Fc(E.Promise) && Fc(E.Symbol) ? oc(E.document, a).id = "google_shimpl" : (a = fc(document, "IFRAME"), a.id = "google_shimpl", a.style.display = "none", E.document.documentElement.appendChild(a), Wi(E, "google_shimpl", "<!doctype html><html><body><" + (ok + ">google_sl_win=window.parent;google_async_iframe_id='google_shimpl';</") +
                (ok + ">") + sk() + "</body></html>"), a.contentWindow.document.close())
        }
    }

    var qk = Cf(215, function (a) {
        var b = a.google_sa_queue, c = b.shift();
        a.google_sa_impl || Df("shimpl", {t: "no_fn"});
        "function" == xa(c) && Bf(216, c);
        b.length && a.setTimeout(function () {
            return qk(a)
        }, 0)
    });

    function tk(a, b, c) {
        a.google_sa_queue = a.google_sa_queue || [];
        a.google_sa_impl ? c(b) : a.google_sa_queue.push(b)
    }

    function sk() {
        var a = rk();
        return "<" + ok + ' src="' + a + '"></' + ok + ">"
    }

    function rk() {
        var a = "/show_ads_impl.js";
        a = void 0 === a ? "/show_ads_impl.js" : a;
        a:{
            if (Tc) try {
                var b = E.google_cafe_host || E.top.google_cafe_host;
                if (b) {
                    var c = b;
                    break a
                }
            } catch (d) {
            }
            c = Xc()
        }
        return Pf(c, ["/pagead/js/", Sc(), "/r20190131", a, ""].join(""), "https")
    }

    function uk(a, b, c, d) {
        return function () {
            var e = !1;
            d && Tj().al(3E4);
            try {
                Wi(a, b, c), e = !0
            } catch (g) {
                var f = Lg().google_jobrunner;
                Sj(f) && f.rl()
            }
            e && (e = Yj("google_async_rrc", c), (new Xj(a)).set(b, uk(a, b, e, !1)))
        }
    }

    function vk(a) {
        if (!Xi) a:{
            for (var b = [p.top], c = [], d = 0, e; e = b[d++];) {
                c.push(e);
                try {
                    if (e.frames) for (var f = e.frames.length, g = 0; g < f && 1024 > b.length; ++g) b.push(e.frames[g])
                } catch (k) {
                }
            }
            for (b = 0; b < c.length; b++) try {
                var h = c[b].frames.google_esf;
                if (h) {
                    Xi = h;
                    break a
                }
            } catch (k) {
            }
            Xi = null
        }
        if (!Xi) {
            if (/[^a-z0-9-]/.test(a)) return null;
            c = fc(document, "IFRAME");
            c.id = "google_esf";
            c.name = "google_esf";
            h = Of(Rc("", "googleads.g.doubleclick.net"), ["/pagead/html/", Sc(), "/r20190131/zrt_lookup.html#",
                encodeURIComponent("")].join(""));
            c.src = h;
            c.style.display = "none";
            c.setAttribute("data-ad-client", Hh(a));
            return c
        }
        return null
    }

    function wk(a, b, c) {
        xk(a, b, c, function (d, e, f) {
            d = d.document;
            for (var g = e.id, h = 0; !g || d.getElementById(g + "_anchor");) g = "aswift_" + h++;
            e.id = g;
            e.name = g;
            g = Number(f.google_ad_width || 0);
            h = Number(f.google_ad_height || 0);
            var k = f.ds || "";
            k && (k += k.endsWith(";") ? "" : ";");
            var m = "";
            if (!f.google_enable_single_iframe) {
                m = ["<iframe"];
                for (n in e) e.hasOwnProperty(n) && m.push(n + "=" + e[n]);
                m.push('style="left:0;position:absolute;top:0;border:0px;width:' + (g + "px;height:" + (h + 'px;"')));
                m.push("></iframe>");
                m = m.join(" ")
            }
            var n = e.id;
            var r = "";
            r = void 0 === r ? "" : r;
            g = "border:none;height:" + h + "px;margin:0;padding:0;position:relative;visibility:visible;width:" + (g + "px;background-color:transparent;");
            n = ['<ins id="' + (n + '_expand"'), ' style="display:inline-table;' + g + (void 0 === k ? "" : k) + '"', r ? ' data-ad-slot="' + r + '">' : ">", '<ins id="' + (n + '_anchor" style="display:block;') + g + '">', m, "</ins></ins>"].join("");
            16 == f.google_reactive_ad_format ? (f = d.createElement("div"), f.innerHTML = n, c.appendChild(f.firstChild)) : c.innerHTML = n;
            return e.id
        })
    }

    function xk(a, b, c, d) {
        var e = b.google_ad_width, f = b.google_ad_height;
        (!Bb && !Cb || J(325)) && J(284) && (b.google_enable_single_iframe = !0);
        var g = {};
        null != e && (g.width = e && '"' + e + '"');
        null != f && (g.height = f && '"' + f + '"');
        g.frameborder = '"0"';
        g.marginwidth = '"0"';
        g.marginheight = '"0"';
        g.vspace = '"0"';
        g.hspace = '"0"';
        g.allowtransparency = '"true"';
        g.scrolling = '"no"';
        g.allowfullscreen = '"true"';
        g.onload = '"' + Zj + '"';
        d = d(a, g, b);
        yk(a, c, b);
        (c = vk(b.google_ad_client)) && a.document.documentElement.appendChild(c);
        c = Ga;
        e = (new Date).getTime();
        b.google_lrv = Sc();
        b.google_async_iframe_id = d;
        b.google_unique_id = fe(a);
        b.google_start_time = c;
        b.google_bpp = e > c ? e - c : 1;
        b.google_async_rrc = 0;
        a.google_sv_map = a.google_sv_map || {};
        a.google_sv_map[d] = b;
        a.google_t12n_vars = Ch;
        if (b.google_enable_single_iframe) {
            var h = {pubWin: a, iframeWin: null, vars: b};
            tk(a, function () {
                a.google_sa_impl(h)
            }, a.document.getElementById(d + "_anchor") ? Uj : Vj)
        } else tk(a, uk(a, d, ["<!doctype html><html><body>", "<" + ok + ">", "google_sl_win=window.parent;google_iframe_start_time=new Date().getTime();",
            'google_async_iframe_id="' + d + '";', "</" + ok + ">", "<" + ok + ">window.parent.google_sa_impl({iframeWin: window, pubWin: window.parent, vars: window.parent['google_sv_map']['" + (d + "']});</") + ok + ">", "</body></html>"].join(""), !0), a.document.getElementById(d) ? Uj : Vj)
    }

    function yk(a, b, c) {
        var d = c.google_ad_output, e = c.google_ad_format, f = c.google_ad_width || 0, g = c.google_ad_height || 0;
        e || "html" != d && null != d || (e = f + "x" + g);
        d = !c.google_ad_slot || c.google_override_format || !bc[c.google_ad_width + "x" + c.google_ad_height] && "aa" == c.google_loader_used;
        e && d ? e = e.toLowerCase() : e = "";
        c.google_ad_format = e;
        if ("number" !== typeof c.google_reactive_sra_index || !c.google_ad_unit_key) {
            e = [c.google_ad_slot, c.google_orig_ad_format || c.google_ad_format, c.google_ad_type, c.google_orig_ad_width || c.google_ad_width,
                c.google_orig_ad_height || c.google_ad_height];
            d = [];
            f = 0;
            for (g = b; g && 25 > f; g = g.parentNode, ++f) 9 === g.nodeType ? d.push("") : d.push(g.id);
            (d = d.join()) && e.push(d);
            c.google_ad_unit_key = vc(e.join(":")).toString();
            var h = void 0 === h ? !1 : h;
            e = [];
            for (d = 0; b && 25 > d; ++d) {
                f = "";
                void 0 !== h && h || (f = (f = 9 !== b.nodeType && b.id) ? "/" + f : "");
                a:{
                    if (b && b.nodeName && b.parentElement) {
                        g = b.nodeName.toString().toLowerCase();
                        for (var k = b.parentElement.childNodes, m = 0, n = 0; n < k.length; ++n) {
                            var r = k[n];
                            if (r.nodeName && r.nodeName.toString().toLowerCase() ===
                                g) {
                                if (b === r) {
                                    g = "." + m;
                                    break a
                                }
                                ++m
                            }
                        }
                    }
                    g = ""
                }
                e.push((b.nodeName && b.nodeName.toString().toLowerCase()) + f + g);
                b = b.parentElement
            }
            h = e.join() + ":";
            b = [];
            if (a) try {
                var w = a.parent;
                for (e = 0; w && w !== a && 25 > e; ++e) {
                    var u = w.frames;
                    for (d = 0; d < u.length; ++d) if (a === u[d]) {
                        b.push(d);
                        break
                    }
                    a = w;
                    w = a.parent
                }
            } catch (D) {
            }
            c.google_ad_dom_fingerprint = vc(h + b.join()).toString()
        }
    }

    var zk = !Vc;

    function Ak(a) {
        var b = a.value,
            c = "https://partner.googleadservices.com/gampad/cookie.js?domain=" + a.domain + "&callback=_gfp_s_&client=" + a.ab;
        a.$a && (c += "&test=1");
        b && (c += "&cookie=" + encodeURIComponent(b) + "&crv=" + Number("Test" !== b));
        return c
    }

    function Bk(a) {
        var b = void 0 === b ? Ak : b;
        var c = E._gfp_a_;
        if ("boolean" !== typeof c) throw Error("Illegal value of _gfp_a_: " + c);
        if (c) {
            c = E._gfp_p_;
            if ("boolean" !== typeof c) throw Error("Illegal value of _gfp_p_: " + c);
            if (!c) {
                if (J(225)) {
                    c = J(226);
                    var d = new ek(c);
                    navigator.cookieEnabled && (E._gfp_s_ = Cf(629, function (e) {
                        delete E._gfp_s_;
                        if (!e) throw Error("Invalid JSONP response");
                        if (e = e._cookies_) {
                            var f = e[0];
                            if (!f) throw Error("Invalid JSONP response");
                            e = f._value_;
                            var g = f._expires_, h = f._path_;
                            f = f._domain_;
                            if ("string" !==
                                typeof e || "number" !== typeof g || "string" !== typeof h || "string" !== typeof f) throw Error("Invalid JSONP response");
                            d.write($b(Zb(Yb(Xb(e), g), h), f))
                        }
                    }), oc(E.document, b({domain: E.location.hostname, ab: a, $a: c, value: fk(d)})))
                }
                E._gfp_p_ = !0
            }
        }
    };

    function Ck(a, b) {
        a = a.attributes;
        for (var c = a.length, d = 0; d < c; d++) {
            var e = a[d];
            if (/data-/.test(e.name)) {
                var f = $a(e.name.replace("data-matched-content", "google_content_recommendation").replace("data", "google").replace(/-/g, "_"));
                if (!b.hasOwnProperty(f)) {
                    e = e.value;
                    var g = {};
                    g = (g.google_reactive_ad_format = Pc, g.google_allow_expandable_ads = Ec, g);
                    e = g.hasOwnProperty(f) ? g[f](e, null) : e;
                    null !== e && (b[f] = e)
                }
            }
        }
    }

    function Dk(a) {
        if (a = Zd(a)) switch (a.data && a.data.autoFormat) {
            case "rspv":
                return 13;
            case "mcrspv":
                return 15;
            default:
                return 14
        } else return 12
    }

    function Ek(a, b, c) {
        Ck(a, b);
        if (c.document && c.document.body && !Kj(c, b) && !b.google_reactive_ad_format) {
            var d = parseInt(a.style.width, 10), e = Wj(a, c);
            if (0 < e && d > e) {
                var f = parseInt(a.style.height, 10);
                d = !!bc[d + "x" + f];
                var g = e;
                if (d) {
                    var h = cc(e, f);
                    if (h) g = h, b.google_ad_format = h + "x" + f + "_0ads_al"; else throw new O("No slot size for availableWidth=" + e);
                }
                b.google_ad_resize = !0;
                b.google_ad_width = g;
                d || (b.google_ad_format = null, b.google_override_format = !0);
                e = g;
                a.style.width = e + "px";
                f = yj(e, "auto", c, a, b);
                g = e;
                f.a.ba(c, b, a);
                aj(f,
                    g, b);
                f = f.a;
                b.google_responsive_formats = null;
                f.minWidth() > e && !d && (b.google_ad_width = f.minWidth(), a.style.width = f.minWidth() + "px")
            }
        }
        d = a.offsetWidth || R(a, c, "width", G) || b.google_ad_width || 0;
        e = Fa(yj, d, "auto", c, a, b, !1, !0);
        f = le(c) || c;
        g = b.google_ad_client;
        f = f.location && "#ftptohbh" === f.location.hash ? 2 : Ah(f.location, "google_responsive_slot_debug") || Ah(f.location, "google_responsive_slot_preview") || J(217) ? 1 : J(218) ? 2 : Ih(f, 1, g) ? 1 : 0;
        if (g = 0 !== f) b:if (!(488 > P(c) || J(216)) || b.google_reactive_ad_format || Kj(c, b) || jg(a,
            b)) g = !1; else {
            for (g = a; g; g = g.parentElement) {
                h = pc(g, c);
                if (!h) {
                    b.gfwrnwer = 18;
                    g = !1;
                    break b
                }
                if (!Oa(["static", "relative"], h.position)) {
                    b.gfwrnwer = 17;
                    g = !1;
                    break b
                }
            }
            if (!J(216) && (g = og(c, a, d, .3, b), !0 !== g)) {
                b.gfwrnwer = g;
                g = !1;
                break b
            }
            g = ke(c) == c ? !0 : !1
        }
        g ? (b.google_resizing_allowed = !0, b.ovlp = !0, 2 === f ? (f = {}, aj(e(), d, f), b.google_resizing_width = f.google_ad_width, b.google_resizing_height = f.google_ad_height, f.ds && (b.ds = f.ds), b.iaaso = !1) : (b.google_ad_format = "auto", b.iaaso = !0, b.armr = 1), d = !0) : d = !1;
        if (e = Kj(c, b)) Mj(e, a, b,
            c, d); else {
            if (jg(a, b)) {
                if (d = pc(a, c)) a.style.width = d.width, a.style.height = d.height, ig(d, b);
                b.google_ad_width || (b.google_ad_width = a.offsetWidth);
                b.google_ad_height || (b.google_ad_height = a.offsetHeight);
                b.google_loader_features_used = 256;
                b.google_responsive_auto_format = Dk(c)
            } else ig(a.style, b);
            c.location && "#gfwmrp" == c.location.hash || 12 == b.google_responsive_auto_format && "true" == b.google_full_width_responsive && !me(c, Vh.s) ? Mj(10, a, b, c, !1) : me(c, Wh.s) && 12 == b.google_responsive_auto_format && (a = pg(a.offsetWidth ||
                parseInt(a.style.width, 10) || b.google_ad_width, c, a, b), !0 !== a ? (b.efwr = !1, b.gfwrnwer = a) : b.efwr = !0)
        }
    };

    function Fk(a, b, c) {
        var d = window;
        return function () {
            var e = ef(), f = 3;
            try {
                var g = b.apply(this, arguments)
            } catch (h) {
                f = 13;
                if (c) return c(a, h), g;
                throw h;
            } finally {
                d.google_measure_js_timing && e && (e = {
                    label: a.toString(),
                    value: e,
                    duration: (ef() || 0) - e,
                    type: f
                }, f = d.google_js_reporting_queue = d.google_js_reporting_queue || [], 2048 > f.length && f.push(e))
            }
            return g
        }
    }

    function Gk(a, b) {
        return Fk(a, b, function (c, d) {
            (new rf).J(c, d)
        })
    };

    function Z(a, b) {
        return null == b ? "&" + a + "=null" : "&" + a + "=" + Math.floor(b)
    }

    function Hk() {
        var a = this;
        this.I = this.$ = this.o = this.j = this.f = 0;
        this.K = !1;
        this.u = this.g = this.c = 0;
        this.L = .1 > Math.random();
        this.P = p === p.top;
        var b = document.querySelector("[data-google-query-id]");
        if (this.a = b ? b.getAttribute("data-google-query-id") : null) b = null; else {
            if ("number" !== typeof p.goog_pvsid) try {
                Object.defineProperty(p, "goog_pvsid", {value: Math.floor(Math.random() * Math.pow(2, 52))})
            } catch (c) {
            }
            b = Number(p.goog_pvsid) || -1
        }
        this.T = b;
        this.L && (b = "https://pagead2.googlesyndication.com/pagead/gen_204?id=plmetrics" +
            (this.a ? "&qqid=" + encodeURIComponent(this.a) : Z("pvsid", this.T)), b += Z("test", 1), b += "&top=" + (this.P ? 1 : 0), Ik(b));
        this.aa = new PerformanceObserver(Gk(640, function (c) {
            c = ea(c.getEntries());
            for (var d = c.next(); !d.done; d = c.next()) {
                d = d.value;
                if ("layout-shift" === d.entryType) {
                    var e = d;
                    e.hadRecentInput || J(241) && !(.01 < e.value) || (a.f += Number(e.value), Number(e.value) > a.j && (a.j = Number(e.value)), a.o += 1)
                }
                "largest-contentful-paint" === d.entryType && (e = d, a.$ = Math.floor(e.renderTime || e.loadTime));
                "first-input" === d.entryType &&
                (e = d, a.I = Number((e.processingStart - e.startTime).toFixed(3)), a.K = !0);
                "longtask" === d.entryType && (a.c += d.duration, d.duration > a.g && (a.g = d.duration), a.u += 1)
            }
        }));
        this.U = !1;
        this.b = Gk(641, this.b.bind(this))
    }

    na(Hk, Yc);
    Hk.prototype.b = function () {
        var a = document;
        if (2 === ({
            visible: 1,
            hidden: 2,
            prerender: 3,
            preview: 4,
            unloaded: 5
        }[a.visibilityState || a.webkitVisibilityState || a.mozVisibilityState || ""] || 0) && !this.U) {
            this.U = !0;
            this.aa.takeRecords();
            a = "https://pagead2.googlesyndication.com/pagead/gen_204?id=plmetrics";
            window.LayoutShift && (a += "&cls=" + this.f.toFixed(3), a += "&mls=" + this.j.toFixed(3), a += Z("nls", this.o));
            window.LargestContentfulPaint && (a += Z("lcp", this.$));
            window.PerformanceEventTiming && this.K && (a += Z("fid", this.I));
            window.PerformanceLongTaskTiming &&
            (a += Z("cbt", this.c), a += Z("mbt", this.g), a += Z("nlt", this.u));
            for (var b = 0, c = ea(document.getElementsByTagName("iframe")), d = c.next(); !d.done; d = c.next()) if (d = d.value, d.id.includes("google_ads_iframe_") || d.id.includes("aswift")) b += 1;
            a += Z("nif", b);
            a += Z("ifi", ee(window));
            b = Ph.h().a();
            a += "&eid=" + encodeURIComponent(b.join());
            this.L && (a += Z("test", 1));
            a += "&top=" + (this.P ? 1 : 0);
            a += this.a ? "&qqid=" + encodeURIComponent(this.a) : Z("pvsid", this.T);
            Ik(a)
        }
    };

    function Ik(a) {
        window.fetch(a, {keepalive: !0, credentials: "include", redirect: "follow", method: "get", mode: "no-cors"})
    };var Jk = ["https://www.google.com"], Kk = void 0;

    function Lk(a) {
        this.c = Jk;
        this.a = 2;
        this.b = a
    }

    na(Lk, Yc);

    function Mk(a) {
        null === a.b || 3 <= a.a || (a.a = 3, Ha(a.c, function (b) {
            a.b.fetch(b + "/.well-known/trust-token", {
                keepalive: !0,
                redirect: "follow",
                method: "get",
                mode: "no-cors",
                hb: {type: "srr-token-redemption", bb: b, eb: "none"}
            }).then(function (c) {
                if (!c.ok) throw Error("Network response was not ok");
                c.blob();
                a.a = 5
            }).catch(function () {
                4 > a.a && (a.a = 4)
            })
        }))
    };

    function Nk(a) {
        return je.test(a.className) && "done" != a.getAttribute("data-adsbygoogle-status")
    }

    function Ok(a, b) {
        a.setAttribute("data-adsbygoogle-status", "done");
        Pk(a, b)
    }

    function Pk(a, b) {
        var c = window, d = ie();
        d.google_spfd || (d.google_spfd = Ek);
        (d = b.google_reactive_ads_config) || Ek(a, b, c);
        if (!Qk(a, b, c)) {
            d || (c.google_lpabyc = ei(c, a));
            if (d) {
                d = d.page_level_pubvars || {};
                if (K(E).page_contains_reactive_tag && !K(E).allow_second_reactive_tag) {
                    if (d.pltais) {
                        oe(!1);
                        return
                    }
                    throw new O("Only one 'enable_page_level_ads' allowed per page.");
                }
                K(E).page_contains_reactive_tag = !0;
                oe(7 === d.google_pgb_reactive)
            } else de(c);
            be(ck, function (e, f) {
                b[f] = b[f] || c[f]
            });
            b.google_loader_used = "aa";
            b.google_reactive_tag_first =
                1 === (K(E).first_tag_on_page || 0);
            Bf(164, function () {
                wk(c, b, a)
            })
        }
    }

    function Qk(a, b, c) {
        var d = b.google_reactive_ads_config;
        if (d) {
            var e = d.page_level_pubvars;
            var f = (ya(e) ? e : {}).google_tag_origin
        }
        e = "string" === typeof a.className && /(\W|^)adsbygoogle-noablate(\W|$)/.test(a.className);
        var g = b.google_ad_slot;
        var h = f || b.google_tag_origin;
        f = K(c);
        pe(f.ad_whitelist || [], g, h) ? g = null : (h = f.space_collapsing || "none", g = (g = pe(f.ad_blacklist || [], g)) ? {
            pa: !0,
            Ea: g.space_collapsing || h
        } : f.remove_ads_by_default ? {pa: !0, Ea: h, ha: f.ablation_viewport_offset} : null);
        if (g && g.pa && "on" != b.google_adtest &&
            !e && (e = Bg(a, c), !g.ha || g.ha && (e || 0) >= g.ha)) return a.className += " adsbygoogle-ablated-ad-slot", c = c.google_sv_map = c.google_sv_map || {}, d = za(a), c[b.google_element_uid] = b, a.setAttribute("google_element_uid", d), "slot" == g.Ea && (null !== Dc(a.getAttribute("width")) && a.setAttribute("width", 0), null !== Dc(a.getAttribute("height")) && a.setAttribute("height", 0), a.style.width = "0px", a.style.height = "0px"), !0;
        if ((e = pc(a, c)) && "none" == e.display && !("on" == b.google_adtest || 0 < b.google_reactive_ad_format || d)) return c.document.createComment &&
        a.appendChild(c.document.createComment("No ad requested because of display:none on the adsbygoogle tag")), !0;
        a = null == b.google_pgb_reactive || 3 === b.google_pgb_reactive;
        return 1 !== b.google_reactive_ad_format && 8 !== b.google_reactive_ad_format || !a ? !1 : (p.console && p.console.warn("Adsbygoogle tag with data-reactive-ad-format=" + b.google_reactive_ad_format + " is deprecated. Check out page-level ads at https://www.google.com/adsense"), !0)
    }

    function Rk(a) {
        var b = document.getElementsByTagName("INS");
        for (var c = 0, d = b[c]; c < b.length; d = b[++c]) {
            var e = d;
            if (Nk(e) && "reserved" != e.getAttribute("data-adsbygoogle-status") && (!a || d.id == a)) return d
        }
        return null
    }

    function Sk() {
        var a = fc(document, "INS");
        a.className = "adsbygoogle";
        a.className += " adsbygoogle-noablate";
        Hc(a);
        return a
    }

    function Tk(a) {
        var b = {};
        be(dg, function (e, f) {
            !1 === a.enable_page_level_ads ? b[f] = !1 : a.hasOwnProperty(f) && (b[f] = a[f])
        });
        ya(a.enable_page_level_ads) && (b.page_level_pubvars = a.enable_page_level_ads);
        var c = Sk();
        ac.body.appendChild(c);
        var d = {};
        d = (d.google_reactive_ads_config = b, d.google_ad_client = a.google_ad_client, d);
        d.google_pause_ad_requests = K(E).pause_ad_requests || !1;
        Ok(c, d)
    }

    function Uk(a) {
        function b() {
            return Tk(a)
        }

        var c = void 0 === c ? ac : c;
        var d = le(window);
        if (!d) throw new O("Page-level tag does not work inside iframes.");
        gg(d).wasPlaTagProcessed = !0;
        if (c.body || "complete" == c.readyState || "interactive" == c.readyState) b(); else {
            var e = Ra(Cf(191, b));
            ec(c, "DOMContentLoaded", e);
            (new p.MutationObserver(function (f, g) {
                c.body && (e(), g.disconnect())
            })).observe(c, {childList: !0, subtree: !0})
        }
    }

    function Vk(a) {
        var b = {};
        Bf(165, function () {
            Wk(a, b)
        }, function (c) {
            c.client = c.client || b.google_ad_client || a.google_ad_client;
            c.slotname = c.slotname || b.google_ad_slot;
            c.tag_origin = c.tag_origin || b.google_tag_origin
        })
    }

    function Xk(a) {
        delete a.google_checked_head;
        F(a, function (b, c) {
            re[c] || (delete a[c], b = c.replace("google", "data").replace(/_/g, "-"), p.console.warn("AdSense head tag doesn't support " + b + " attribute."))
        })
    }

    function Wk(a, b) {
        if (null == a) throw new O("push() called with no parameters.");
        Ga = (new Date).getTime();
        pk();
        a:{
            if (void 0 != a.enable_page_level_ads) {
                if ("string" === typeof a.google_ad_client) {
                    var c = !0;
                    break a
                }
                throw new O("'google_ad_client' is missing from the tag config.");
            }
            c = !1
        }
        if (c) Yk(a, b); else if ((c = a.params) && be(c, function (e, f) {
            b[f] = e
        }), "js" === b.google_ad_output) console.warn("Ads with google_ad_output='js' have been deprecated and no longer work. Contact your AdSense account manager or switch to standard AdSense ads.");
        else {
            a = Zk(a.element);
            Ck(a, b);
            c = K(p).head_tag_slot_vars || {};
            F(c, function (e, f) {
                b.hasOwnProperty(f) || (b[f] = e)
            });
            if (a.hasAttribute("data-require-head") && !K(p).head_tag_slot_vars) throw new O("AdSense head tag is missing. AdSense body tags don't work without the head tag. You can copy the head tag from your account on https://adsense.com.");
            if (!b.google_ad_client) throw new O("Ad client is missing from the slot.");
            b.google_apsail = Mh(b.google_ad_client);
            var d = (c = 0 === (K(E).first_tag_on_page || 0) && ci(b)) && di(c);
            c && !d && (Yk(c), K(E).skip_next_reactive_tag = !0);
            0 === (K(E).first_tag_on_page || 0) && (K(E).first_tag_on_page = 2);
            "_gfp_p_" in E || (E._gfp_p_ = !1);
            Bk(b.google_ad_client);
            b.google_pause_ad_requests = K(E).pause_ad_requests || !1;
            Ok(a, b);
            c && d && $k(c)
        }
    }

    function $k(a) {
        Mc(function () {
            gg(p).wasPlaTagProcessed || p.adsbygoogle && p.adsbygoogle.push(a)
        })
    }

    function Yk(a, b) {
        if (K(E).skip_next_reactive_tag) K(E).skip_next_reactive_tag = !1; else {
            0 === (K(E).first_tag_on_page || 0) && (K(E).first_tag_on_page = 1);
            b && a.tag_partner && (ne(p, a.tag_partner), ne(b, a.tag_partner));
            a:if (!K(E).ama_ran_on_page) {
                if (J(316)) var c = null; else try {
                    c = p.localStorage.getItem("google_ama_config")
                } catch (r) {
                    c = null
                }
                try {
                    var d = c ? Sb(Ee, c) : null
                } catch (r) {
                    d = null
                }
                if (b = d) if (c = B(b, Ge, 3), !c || z(c, 1) <= Date.now()) try {
                    p.localStorage.removeItem("google_ama_config")
                } catch (r) {
                    Lf(p, {lserr: 1})
                } else {
                    if (di(a) &&
                        (c = Ne(C(b, He, 7)), !c || !Kb(c, 8))) break a;
                    K(E).ama_ran_on_page = !0;
                    (d = B(b, Ke, 13)) && 1 === z(d, 1) && (c = 0, (d = B(d, Le, 6)) && z(d, 3) && (c = z(d, 3) || 0), d = K(p), d.remove_ads_by_default = !0, d.space_collapsing = "slot", d.ablation_viewport_offset = c);
                    Sf(3, [Qb(b)]);
                    c = a.google_ad_client;
                    d = Gf(If, new Ff(null, Mf(ya(a.enable_page_level_ads) ? a.enable_page_level_ads : {})));
                    try {
                        var e = Ne(C(b, He, 7)), f;
                        if (f = e) b:{
                            var g = z(e, 2);
                            if (g) for (var h = 0; h < g.length; h++) if (1 == g[h]) {
                                f = !0;
                                break b
                            }
                            f = !1
                        }
                        if (f) {
                            if (z(e, 4)) {
                                f = {};
                                var k = new Ff(null, (f.google_package =
                                    z(e, 4), f));
                                d = Gf(d, k)
                            }
                            var m = new kh(c, b, e, d), n = new qh;
                            (new vh(m, n)).start();
                            n.b.then(Fa(xh, p), Fa(yh, p))
                        }
                    } catch (r) {
                        Lf(p, {atf: -1})
                    }
                }
            }
            Uk(a)
        }
    }

    function Zk(a) {
        if (a) {
            if (!Nk(a) && (a.id ? a = Rk(a.id) : a = null, !a)) throw new O("'element' has already been filled.");
            if (!("innerHTML" in a)) throw new O("'element' is not a good DOM element.");
        } else if (a = Rk(), !a) throw new O("All ins elements in the DOM with class=adsbygoogle already have ads in them.");
        return a
    }

    function al() {
        yf();
        sf.Ba(Ef);
        Bf(166, bl)
    }

    function bl() {
        var a = $d(Zd(E)) || E, b = K(a);
        if (b.plle) Si(si(a), 1); else {
            b.plle = !0;
            null == xc(a, "google_pem_mod") && Ac(a, "google_pem_mod");
            var c = [null, null];
            try {
                var d = JSON.parse("[[[259,null,null,[1]],[225,null,null,[1]],[209,null,null,[1]],[205,null,null,[1]],[null,29,null,[null,2]],[null,30,null,[null,3]],[270,null,null,[1]],[210,null,null,[1]],[211,null,null,[1]],[284,null,null,[1]],[207,null,null,[1]],[215,null,null,[1]],[261,null,null,[1]],[272,null,null,[1]],[230,null,null,[1]],[191,null,null,[1]],[182,null,null,[1]],[null,null,null,[null,null,null,[\x22facebook[.]com\x22,\x22whatsapp[.]com\x22,\x22youtube[.]com\x22,\x22google[.]com\x22,\x22\\\\/ads?\\\\/\x22]],null,9]],[[10,[[1,[[44717111],[44717112,[[316,null,null,[1]]]]],null,null,null,32,18],[1,[[44717113],[44717114,[[316,null,null,[1]]]]],null,null,null,32,18],[3,[[44717727],[44717728],[44717729],[44717730]]],[1,[[21065070],[21065071],[21065072,[[243,null,null,[1]]]],[21065073,[[243,null,null,[1]]]]]],[50,[[21065531],[21065532]],null,null,null,13,null,300],[10,[[21065214,[[190,null,null,[1]]],[1,[[12,null,null,null,2,null,\x22\\\\.wiki(dogs|how)(-fun)?\\\\.\x22]]]],[21065215,[[265,null,null,[1]],[260,null,null,[1]],[190,null,null,[1]]],[1,[[12,null,null,null,2,null,\x22\\\\.wiki(dogs|how)(-fun)?\\\\.\x22]]]]],null,null,null,26],[500,[[21065472,null,[1,[[12,null,null,null,2,null,\x22\\\\.wiki(dogs|how)(-fun)?\\\\.\x22]]]],[21065473,[[266,null,null,[1]]],[1,[[12,null,null,null,2,null,\x22\\\\.wiki(dogs|how)(-fun)?\\\\.\x22]]]]],null,null,null,29,14],[500,[[21065474,null,[1,[[12,null,null,null,2,null,\x22\\\\.wiki(dogs|how)(-fun)?\\\\.\x22]]]],[21065475,[[266,null,null,[1]]],[1,[[12,null,null,null,2,null,\x22\\\\.wiki(dogs|how)(-fun)?\\\\.\x22]]]]],null,null,null,29,14],[10,[[44716442,null,[1,[[12,null,null,null,2,null,\x22\\\\.wiki(dogs|how)(-fun)?\\\\.\x22]]]],[44716443,[[310,null,null,[1]]],[1,[[12,null,null,null,2,null,\x22\\\\.wiki(dogs|how)(-fun)?\\\\.\x22]]]]],null,null,null,31,16],[10,[[44716444,null,[1,[[12,null,null,null,2,null,\x22\\\\.wiki(dogs|how)(-fun)?\\\\.\x22]]]],[44716445,[[310,null,null,[1]]],[1,[[12,null,null,null,2,null,\x22\\\\.wiki(dogs|how)(-fun)?\\\\.\x22]]]]],null,null,null,31,16],[20,[[182982000,[[218,null,null,[1]]],[1,[[12,null,null,null,2,null,\x22\\\\.wiki(dogs|how)(-fun)?\\\\.\x22]]]],[182982100,[[217,null,null,[1]]],[1,[[12,null,null,null,2,null,\x22\\\\.wiki(dogs|how)(-fun)?\\\\.\x22]]]]],null,null,null,7,8],[20,[[182982200,null,[1,[[12,null,null,null,2,null,\x22\\\\.wiki(dogs|how)(-fun)?\\\\.\x22]]]],[182982300,null,[1,[[12,null,null,null,2,null,\x22\\\\.wiki(dogs|how)(-fun)?\\\\.\x22]]]]],null,null,null,7,8],[10,[[182984000,null,[4,null,23,null,null,null,null,[\x221\x22]]],[182984100,[[218,null,null,[1]]],[4,null,23,null,null,null,null,[\x221\x22]]]],null,null,null,12,10],[10,[[182984200,null,[4,null,23,null,null,null,null,[\x221\x22]]],[182984300,null,[4,null,23,null,null,null,null,[\x221\x22]]]],null,null,null,12,10],[1,[[21064801],[21064802,[[236,null,null,[1]]]]]],[50,[[21065925]],null,23],[50,[[21065926,[[284,null,null,[]]]]],null,23],[10,[[21066004],[21066005,[[325,null,null,[1]]]]],null,23],[10,[[44715380,[[290,null,null,[1]],[190,null,null,[1]]]],[44715381,[[290,null,null,[1]],[190,null,null,[1]]]]],null,null,null,6]]],[12,[[50,[[44718965],[44718966,[[289,null,null,[1]]]]],null,null,null,13,null,200],[20,[[21065724],[21065725,[[203,null,null,[1]]]]],[4,null,9,null,null,null,null,[\x22LayoutShift\x22]]],[1,[[21065755],[21065756,[[312,null,null,[1]]]]],null,21],[1,[[21065757],[21065758,[[312,null,null,[1]]]]],[4,null,9,null,null,null,null,[\x22hasTrustToken\x22]],21],[1,[[21065784]]],[1,[[21065785,null,[4,null,8,null,null,null,null,[\x22navigator.connection.saveData\x22]]]]],[1,[[21065786,null,[4,null,27,null,null,null,null,[\x22navigator.connection.saveData\x22]]]]],[1,[[21065787,null,[1,[[4,null,27,null,null,null,null,[\x22navigator.connection.saveData\x22]]]]]]],[50,[[44716866],[44716867,[[314,null,null,[1]]]]]]]],[13,[[500,[[21065350],[21065351]],[2,[[3,[[4,null,6,null,null,null,null,[\x2221061508\x22]],[4,null,6,null,null,null,null,[\x2221060549\x22]]]],[4,null,9,null,null,null,null,[\x22ReportingObserver\x22]]]]],[100,[[21065726,null,[4,null,6,null,null,null,null,[\x2221065725\x22]]],[21065727,[[240,null,null,[1]]],[4,null,6,null,null,null,null,[\x2221065725\x22]]],[21065728,[[241,null,null,[1]]],[4,null,6,null,null,null,null,[\x2221065725\x22]]]],[4,null,9,null,null,null,null,[\x22LayoutShift\x22]]]]]]]")
            } catch (m) {
                d = c
            }
            Sf(13, [d]);
            Ri(new zi(d), fi.h(), {ta: ai(a), Ma: Tc}, si(a));
            Ph.h().b(12);
            Ph.h().b(10);
            b.eids = Ja(Ph.h().a(), String).concat(b.eids || []);
            b = b.eids;
            Dh || (Dh = new Eh);
            var e = Dh;
            Wc = !0;
            var f;
            d = Vh;
            var g = Ui(a, Oc(e.a[136]), [d.i, d.s]);
            S(b, g);
            Kh(a, 12) && (d = Sh, c = Rh, g = Vi(a, new ni(0), Oc(e.a[149]), Oc(e.a[150]),
                [d.i, d.s], 4), S(b, g), g == d.i ? f = c.i : g == d.s ? f = c.s : f = "", S(b, f));
            d = Uh;
            g = Vi(a, ri, Oc(e.a[179]), Oc(e.a[180]), [d.i, d.V]);
            S(b, g);
            c = Th;
            g == d.i ? f = c.i : g == d.V ? f = c.V : f = "";
            S(b, f);
            $a("") && S(b, "");
            d = Xh;
            g = Ui(a, Oc(e.a[13]), [d.A, d.i]);
            S(b, g);
            g = Ui(a, 0, [d.oa]);
            S(b, g);
            d = Yh;
            g = Ui(a, Oc(e.a[60]), [d.A, d.i]);
            S(b, g);
            g == Yh.A && (d = Zh, g = Ui(a, Oc(e.a[66]), [d.A, d.i]), S(b, g), d = $h, g = Ui(a, Oc(e.a[137]), [d.A, d.i]), S(b, g));
            d = Wh;
            g = Ui(a, Oc(e.a[98]), [d.i, d.s]);
            S(b, g);
            a = le(a) ||
                a;
            Ah(a.location, "google_mc_lab") && S(b, "242104166")
        }
        if (!t("Trident") && !t("MSIE") || 0 <= hb(tb(), 11)) {
            a = me(E, Zh.A) || me(E, Xh.A) || me(E, Xh.oa);
            tf(a);
            lk();
            ik(".google.com.tw") && (Y[1] = ".google.com.tw");
            nk();
            J(312) && (void 0 === Kk && (document.hasTrustToken ? Kk = new Lk(E) : Kk = null), a = Kk, a && Mk(a));
            E.PerformanceObserver && J(203) && !window.google_plmetrics && (a = new Hk, a.aa.observe({
                entryTypes: ["layout-shift", "largest-contentful-paint", "first-input", "longtask"],
                buffered: !J(240)
            }), document.addEventListener("unload",
                a.b), document.addEventListener("visibilitychange", a.b), window.google_plmetrics = !0);
            if (a = le(p)) a = gg(a), a.tagSpecificState[1] || (a.tagSpecificState[1] = new zh);
            if (b = E.document.querySelector('script[src*="/pagead/js/adsbygoogle.js"][data-ad-client]:not([data-checked-head])')) {
                b.setAttribute("data-checked-head", "true");
                f = K(window);
                if (f.head_tag_slot_vars) throw new O("Only one AdSense head tag supported per page. The second tag is ignored.");
                a = {};
                Ck(b, a);
                Xk(a);
                b = {};
                for (var h in a) b[h] = a[h];
                f.head_tag_slot_vars =
                    b;
                h = {};
                h = (h.google_ad_client = a.google_ad_client, h.enable_page_level_ads = a, h);
                E.adsbygoogle || (E.adsbygoogle = []);
                a = E.adsbygoogle;
                a.loaded ? a.push(h) : a.splice(0, 0, h)
            }
            h = window.adsbygoogle;
            if (!h || !h.loaded) {
                a = {push: Vk, loaded: !0};
                try {
                    Object.defineProperty(a, "requestNonPersonalizedAds", {set: cl}), Object.defineProperty(a, "pauseAdRequests", {set: dl}), Object.defineProperty(a, "cookieOptions", {set: el}), Object.defineProperty(a, "onload", {set: fl})
                } catch (m) {
                }
                if (h) for (f = ea(["requestNonPersonalizedAds", "pauseAdRequests",
                    "cookieOptions"]), b = f.next(); !b.done; b = f.next()) b = b.value, void 0 !== h[b] && (a[b] = h[b]);
                "_gfp_a_" in window || (window._gfp_a_ = zk);
                if (h && h.shift) try {
                    var k;
                    for (f = 20; 0 < h.length && (k = h.shift()) && 0 < f;) Vk(k), --f
                } catch (m) {
                    throw window.setTimeout(al, 0), m;
                }
                window.adsbygoogle = a;
                h && (a.onload = h.onload)
            }
        }
    }

    function cl(a) {
        if (+a) {
            if ((a = nc()) && a.frames && !a.frames.GoogleSetNPA) try {
                var b = a.document, c = new gc(b), d = b.body || b.head && b.head.parentElement;
                if (d) {
                    var e = fc(c.a, "IFRAME");
                    e.name = "GoogleSetNPA";
                    e.id = "GoogleSetNPA";
                    e.setAttribute("style", "display:none;position:fixed;left:-999px;top:-999px;width:0px;height:0px;");
                    d.appendChild(e)
                }
            } catch (f) {
            }
        } else (b = nc().document.getElementById("GoogleSetNPA")) && b.parentNode && b.parentNode.removeChild(b)
    }

    function dl(a) {
        +a ? K(E).pause_ad_requests = !0 : (K(E).pause_ad_requests = !1, a = function () {
            if (!K(E).pause_ad_requests) {
                var b = ie(), c = ie();
                try {
                    if (ac.createEvent) {
                        var d = ac.createEvent("CustomEvent");
                        d.initCustomEvent("adsbygoogle-pub-unpause-ad-requests-event", !1, !1, "");
                        b.dispatchEvent(d)
                    } else if (ce(c.CustomEvent)) {
                        var e = new c.CustomEvent("adsbygoogle-pub-unpause-ad-requests-event", {
                            bubbles: !1,
                            cancelable: !1,
                            detail: ""
                        });
                        b.dispatchEvent(e)
                    } else if (ce(c.Event)) {
                        var f = new Event("adsbygoogle-pub-unpause-ad-requests-event",
                            {bubbles: !1, cancelable: !1});
                        b.dispatchEvent(f)
                    }
                } catch (g) {
                }
            }
        }, p.setTimeout(a, 0), p.setTimeout(a, 1E3))
    }

    function el(a) {
        switch (a) {
            case 0:
                a = !0;
                break;
            case 1:
                a = !1;
                break;
            case 2:
                a = zk;
                break;
            default:
                throw Error("Illegal value of cookieOptions: " + a);
        }
        E._gfp_a_ = a;
        "_gfp_p_" in E && (a = E.google_sv_map, Bk(a[uc(a)].google_ad_client))
    }

    function fl(a) {
        ce(a) && window.setTimeout(a, 0)
    };al();
}).call(this);