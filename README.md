# android-tap-the-black-tiles

An android WebView-based build for my game *tap-the-black-tiles*

## What?

It's a Javascript game embedded in a WebView.

I know, this sounds wrong, but I though since I had already coded that Javascript game, I should just try that to know if it works and if it could theoretically speed up the Android App development process.

## And? What were your results?

Well... It worked. Ish.

I faced a few weird bugs I managed to workaround with weird hacks.

Did it speed up the Android App development process ?

Well... I spent about twice the time it took me to build my Javascript app in embedding it in a WebView.

Still, it would probably have took me more time to rebuild the app from scratch, so... I don't know. I'm probably not going to do that again, as it wasn't that fun.

## Wait! You said it was an experiment! Don't you have a chart or something to show your results?

Erf... Ok, here :

```
                     | Java | Javascript in WebView
Developing the app   | Slow | Fast
App speed at runtime | Fast | Slow
Requires icky hacks  | Nope | Yup
Requires icky code   | Yup  | Nope
```
