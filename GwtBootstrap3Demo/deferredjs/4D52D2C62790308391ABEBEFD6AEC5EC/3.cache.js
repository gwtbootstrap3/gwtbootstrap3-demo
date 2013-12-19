function Rkb(){}
function Gkb(a,b,c){BL.call(this,a,b,c,(hjb(),gjb))}
function dY(a,b){IG(b.q,kLb,true);hH(a,b,a.q);fK(a.a,b)}
function gK(a,b){if(b<0||b>=a.c){throw new xQ}return a.a[b]}
function vqb(a){var b;if(!a.k){b=new Pkb(new Rkb);a.k=b}return a.k}
function eY(){cY.call(this);this.a=new lK(this);this.q[XHb]='breadcrumb'}
function uqb(a){var b;if(!a.j){b=new Gkb(KK(fM(a.a)),vqb(a),tqb(a));aL((gM(a.a),b),rM(gM(a.a)));a.j=b}return a.j}
function Pkb(){var a,b,c,d,e,f,g,i,j,k,n,o,p;VL(this,(a=new Y0,tX(a,(b=new a0,b.a=dJb,__(b),b)),tX(a,(c=new c0,tX(c,(d=new k0,j0(d,(g=new WZ(3),lg(g.q,aLb),g)),d)),tX(c,(e=new f0,tX(e,(i=new eY,dY(i,(j=new i_,yX(j.a,'One'),j)),dY(i,(k=new i_,yX(k.a,'Two'),k)),dY(i,(n=new i_,yX(n.a,'Three'),n)),i)),e)),tX(c,(f=new h0,tX(f,(o=new P0,O0(o,(p=new lR,Df(p.a,'&lt;b:Breadcrumbs&gt;\\n \\s\\s&lt;b:ListItem text="..."&gt;\\n \\s\\s&lt;b:ListItem text="..."&gt;\\n \\s\\s&lt;b:ListItem text="..."&gt;\\n &lt;/b:Breadcrumbs&gt;\\n'),new UC(Gf(p.a))).a),IG(o.q,dLb,true),IG(o.q,eLb,true),o)),f)),c)),a))}
mC(369,370,qGb,eY);_.ac=function fY(a){dY(this,a)};_.Vb=function gY(){var a;if(this.k!=-1&&this.a.c>0){a=gK(this.a,this.a.c-1);IG(a.q,kLb,true)}OG(this)};mC(554,247,uGb,Gkb);mC(557,252,vGb,Pkb);mC(558,1,{},Rkb);mC(721,1,KGb);_.nb=function ktb(){wN(this.b,uqb(this.a.a))};var Ju=iQ(iKb,'BreadcrumbPresenter',554),Lu=iQ(iKb,'BreadcrumbView',557),Ku=iQ(iKb,'BreadcrumbView_BinderImpl',558),kr=iQ(RKb,dJb,369);OGb(ke)(3);