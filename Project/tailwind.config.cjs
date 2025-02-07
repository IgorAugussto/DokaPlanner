/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./index.html", // Garante que o Tailwind funcione no index.html
    "./src/**/*.{vue,js,ts,jsx,tsx}", // Inclui arquivos Vue, TS, JS
  ],
  theme: {
    extend: {}, // Aqui você pode personalizar seu tema
  },
  plugins: [],
};
