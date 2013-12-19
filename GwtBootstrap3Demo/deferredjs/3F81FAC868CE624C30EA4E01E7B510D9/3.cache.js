function Vkb(){}
function Kkb(a,b,c){FL.call(this,a,b,c,(ljb(),kjb))}
function hY(a,b){MG(b.q,yLb,true);lH(a,b,a.q);jK(a.a,b)}
function kK(a,b){if(b<0||b>=a.c){throw new BQ}return a.a[b]}
function zqb(a){var b;if(!a.k){b=new Tkb(new Vkb);a.k=b}return a.k}
function iY(){gY.call(this);this.a=new pK(this);this.q[kIb]='breadcrumb'}
function yqb(a){var b;if(!a.j){b=new Kkb(OK(jM(a.a)),zqb(a),xqb(a));eL((kM(a.a),b),wM(kM(a.a)));a.j=b}return a.j}
function Tkb(){var a,b,c,d,e,f,g,i,j,k,n,o,p;ZL(this,(a=new a1,xX(a,(b=new e0,b.a=rJb,d0(b),b)),xX(a,(c=new g0,xX(c,(d=new o0,n0(d,(g=new $Z(3),fg(g.q,oLb),g)),d)),xX(c,(e=new j0,xX(e,(i=new iY,hY(i,(j=new m_,CX(j.a,'One'),j)),hY(i,(k=new m_,CX(k.a,'Two'),k)),hY(i,(n=new m_,CX(n.a,'Three'),n)),i)),e)),xX(c,(f=new l0,xX(f,(o=new T0,S0(o,(p=new pR,Df(p.a,'&lt;b:Breadcrumbs&gt;\\n \\s\\s&lt;b:ListItem text="..."&gt;\\n \\s\\s&lt;b:ListItem text="..."&gt;\\n \\s\\s&lt;b:ListItem text="..."&gt;\\n &lt;/b:Breadcrumbs&gt;\\n'),new SC(Gf(p.a))).a),MG(o.q,rLb,true),MG(o.q,sLb,true),o)),f)),c)),a))}
kC(372,373,uGb,iY);_.ac=function jY(a){hY(this,a)};_.Vb=function kY(){var a;if(this.k!=-1&&this.a.c>0){a=kK(this.a,this.a.c-1);MG(a.q,yLb,true)}SG(this)};kC(557,250,yGb,Kkb);kC(560,255,zGb,Tkb);kC(561,1,{},Vkb);kC(724,1,OGb);_.nb=function otb(){AN(this.b,yqb(this.a.a))};var Hu=mQ(wKb,'BreadcrumbPresenter',557),Ju=mQ(wKb,'BreadcrumbView',560),Iu=mQ(wKb,'BreadcrumbView_BinderImpl',561),ir=mQ(dLb,rJb,372);SGb(ke)(3);