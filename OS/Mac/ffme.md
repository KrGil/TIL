

```
ffmpeg -i Untitled.mov -pix_fmt rgb8 -r 25 -filter:v "setpts=0.25*PTS" -f gif out.gif
```

