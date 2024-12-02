# a3-348


To run using docker

Build the docker image that we will run:
```bash
docker build -t a3-348 .
```
The instructions for this image are described in the "Dockerfile"
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
*****************************
You have to rerun the build and run command if you want changes to be reflected in your image. You can run them as a one-liner: 

```bash
docker build -t a3-348 . && docker run -it --rm localhost/a3-348 /bin/bash -c "clojure -M -m fido"
```