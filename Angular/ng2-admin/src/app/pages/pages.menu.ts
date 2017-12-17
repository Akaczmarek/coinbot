export const PAGES_MENU = [
  {
    path: 'pages',
    children: [
      {
        path: 'accueil',
        data: {
          menu: {
            title: 'Accueil',
            icon: 'ion-android-home',
            selected: false,
            expanded: false,
            order: 0
          }
        }
      },
      {
        path: 'supervision',  // path for our page
        data: { // custom menu declaration
          menu: {
            title: 'Supervision', // menu title
            icon: 'ion-edit', // menu icon
            pathMatch: 'prefix', // use it if item children not displayed in menu
            selected: false,
            expanded: false,
            order: 0
          }
        }
      },
      {
        path: 'tutos',
        data: {
          menu: {
            title: 'Tutoriels',
            icon: 'ion-android-home',
            selected: false,
            expanded: false,
            order: 0
          }
        }
      },
      {
        path: 'config-bot',
        data: {
          menu: {
            title: 'Configuration du Bot',
            icon: 'ion-android-home',
            selected: false,
            expanded: false,
            order: 0
          }
        }
      }


    ]
  }
];
