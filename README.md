# Musicle

Guess a piece of music by listening to it, similar to the Wordle game format.

## Install

You need to explicitly install the following software:

* sbt, as part of [getting started with Scala](https://docs.scala-lang.org/getting-started/index.html) (or if you prefer, through [its standalone download](https://www.scala-sbt.org/download.html))
* [Node.js](https://nodejs.org/en/)

Other software will be downloaded automatically by the commands below.

## Prepare

Before doing anything, including before importing in an IDE, run

```
$ npm install
```

## Development

Open two terminals.
In the first one, start `sbt` and, within, continuously build the Scala.js project:

```
$ sbt
...
> ~fastLinkJS
...
```

In the second one, start the Vite development server with

```
$ npm run dev
...
```

Follow the URL presented to you by Vite to open the application.

You can now continuously edit the `Main.scala` file, and Vite will automatically reload the page on save.

## Production build

Make a production build with

```
$ npm run build
```

You can then find the built files in the `dist/` directory.
You will need an HTTP server, such as `python3 -m http.server`, to open the files, as Vite rewrites `<script>` tags to prevent cross-origin requests.

## Technology
Built using the following technology:
* [Scala.js](https://www.scala-js.org/)
* [sbt](https://www.scala-sbt.org/)
* [Vite](https://vitejs.dev/)
* [Laminar](https://laminar.dev/)


## TODO
Need to have:
- Search functionality
- Play some sound
- Play sound in chunks
- Submit guesses

Nice to have:
- Music controls (Progress bar and play/pause button)
- Nice looking search results
- Automatically pick sound for the day (Probably by hashing the date)
- Persistent guessing

Neat to have:
- Automatically deploy website on github or own server
- Some kind of leaderboard