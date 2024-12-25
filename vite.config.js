import { defineConfig } from "vite";
import scalaJSPlugin from "@scala-js/vite-plugin-scalajs";

export default defineConfig({
  base: '/musicle/',
  plugins: [scalaJSPlugin()],
});
