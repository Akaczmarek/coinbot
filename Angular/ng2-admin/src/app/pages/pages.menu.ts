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
      },

      {
        path: 'apropos',
        data: {
          menu: {
            title: 'A propos de nous',
            icon: 'ion-information',
            selected: false,
            expanded: false,
            order: 0
          }
        }
      }

    ]
  }
];
