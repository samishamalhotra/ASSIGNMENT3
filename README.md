# a3-348


To run using docker

example: 

```bash
docker build -t a3-348
```

(replace `a3-348` with whatever image name you like)

If you want to execute one run of the program, simply type: 
```bash
docker run a3-348
```

If you want to execute the program to interact with it: 

```bash
docker run -it --rm localhost/a3-348 sh
```
This will put you in the bash shell within the running container based on the image you created earlier

Now, on the shell prompt, run clojure. 
```bash
# clojure -M -m fido
```

