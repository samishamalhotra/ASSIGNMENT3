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

Want to break this command down to learn? 
This is what chatgpt says: 

```bash
docker build -t a3-348 . && docker run -it --rm localhost/a3-348 /bin/bash -c "clojure -M -m fido"
```

### 1. **`docker build -t a3-348 .`**
   This part of the command builds a Docker image from the Dockerfile in the current directory (`.`).

   - **`docker build`**: Tells Docker to build an image.
   - **`-t a3-348`**: Tags the image with the name `a3-348`. This tag allows you to easily refer to the image later, such as when running or pushing it.
   - **`.`**: Refers to the current directory, which is the context in which Docker will look for the Dockerfile and files to copy into the image.

   The result of this step is that Docker will create an image named `a3-348` based on the instructions in the Dockerfile in the current directory.

### 2. **`&&`**
   This is a logical operator in Unix/Linux systems that runs the second command only if the first command (`docker build`) succeeds.

   - If `docker build` fails, the second command (`docker run`) won't execute.

### 3. **`docker run -it --rm localhost/a3-348 /bin/bash -c "clojure -M -m fido"`**
   This part of the command runs the Docker container interactively, using the image that was just built (`localhost/a3-348`), and executes a Clojure command inside the container.

   - **`docker run`**: Runs a new container from the specified image (`localhost/a3-348`).
   - **`-it`**: These options combined allow the container to run interactively (`-i`) and allocate a pseudo-TTY (`-t`), so you can interact with it.
   - **`--rm`**: This option ensures that the container is removed automatically after it exits. This keeps the system clean by removing any stopped containers.
   - **`localhost/a3-348`**: Refers to the image you just built (`a3-348`) that is hosted locally on your machine.
   - **`/bin/bash`**: Specifies that the container should start a Bash shell. This allows you to run commands inside the container.
   - **`-c "clojure -M -m fido"`**: Tells Bash to execute the `clojure -M -m fido` command when the shell starts.
     - **`clojure`**: Runs the Clojure runtime.
     - **`-M`**: Executes the main function in the specified namespace (`-m fido`).
     - **`-m fido`**: Specifies that the `fido` namespace's `-main` function should be executed.

### **Summary of What Happens:**
1. **Build the Docker image**: The `docker build` command creates a Docker image using the `Dockerfile` in the current directory.
2. **Run the Docker container interactively**: The `docker run` command starts a container from the newly built image and executes a Clojure command to run the `-main` function from the `fido` namespace.

This combined command allows you to build and immediately run your Clojure code in the Docker container.