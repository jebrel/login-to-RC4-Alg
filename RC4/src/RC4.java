import java.io.*; 

public class RC4 
{ 

public String operation(String ptext,String key ,boolean enc) throws IOException 
{ 
int temp=0; 
boolean encrbtion=enc;
int s[]=new int[256]; 
int k[]=new int[256]; 
char ptextc[]=ptext.toCharArray(); 
char keyc[]=key.toCharArray(); 
int cipher[]=new int[ptext.length()]; 
int decrypt[]=new int[ptext.length()]; 
int ptexti[]=new int[ptext.length()]; 
int keyi[]=new int[key.length()]; 
for(int i=0;i<ptext.length();i++) 
{ 
ptexti[i]=(int)ptextc[i]; 
} 
for(int i=0;i<key.length();i++) 
{ 
keyi[i]=(int)keyc[i]; 
} 
for(int i=0;i<255;i++) 
{ 
s[i]=i; 
k[i]=keyi[i%key.length()]; 
} 
int j=0; 
for(int i=0;i<255;i++) 
{ 
j=(j+s[i]+k[i])%256; 
temp=s[i]; 
s[i]=s[j]; 
s[j]=temp; 
} 
int i=0; 
j=0; 
int z=0; 
for(int l=0;l<ptext.length();l++) 
{ 
i=(l+1)%256; 
j=(j+s[i])%256; 
temp=s[i]; 
s[i]=s[j]; 
s[j]=temp; 
z=s[(s[i]+s[j])%256]; 
cipher[l]=z^ptexti[l]; 
} 
String s1 = display(cipher); 
String s2 = display(cipher); 
if(encrbtion)
return  s1;
else
   return  s2; 
} 
private String display(int disp[]) 
{
    String res = "";
char convert[]=new char[disp.length]; 
for(int l=0;l<disp.length;l++) 
{ 
convert[l]=(char)disp[l]; 
}
for(int i=0;i<disp.length;i++)
    res += convert[i];
return res;
} 


} 

 